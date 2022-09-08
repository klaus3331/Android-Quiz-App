package edu.gatech.seclass.sdpvocabquiz.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.List;

import edu.gatech.seclass.sdpvocabquiz.Database.DaoUtility;
import edu.gatech.seclass.sdpvocabquiz.R;
import edu.gatech.seclass.sdpvocabquiz.adapters.PracticeAdapter;
import edu.gatech.seclass.sdpvocabquiz.edu.gatech.seclass.sdpvocabquiz.designclasses.PracticeSession;
import edu.gatech.seclass.sdpvocabquiz.edu.gatech.seclass.sdpvocabquiz.designclasses.Quiz;
import edu.gatech.seclass.sdpvocabquiz.edu.gatech.seclass.sdpvocabquiz.designclasses.Statistic;
import edu.gatech.seclass.sdpvocabquiz.edu.gatech.seclass.sdpvocabquiz.designclasses.Student;

public class PracticeQuizActivity extends AppCompatActivity {
    public static final String CURRENT_PRACTICE_QUESTION = "CURRENT_PRACTICE_QUESTION";
    public static final String QUIZ_NAME = "QUIZ_NAME";
    public static final String CORRECT_ANSWER = "CORRECT_ANSWER";

    public static final int QUESTION_CODE = 0;

    private Student currStudent;
    private PracticeSession practiceSession;

    //Declare view and adapter
    RecyclerView practice_recycler;
    RecyclerView.Adapter practice_adapter;

    Button cancelbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.practice_quiz);

        Intent intent = getIntent();
        currStudent = (Student)intent.getExtras().getSerializable(MainMenuActivity.STUDENT);

        practice_recycler = this.<RecyclerView>findViewById(R.id.practice_list);

        List<Quiz> quizzes = DaoUtility.getQuizzesByOthers(currStudent.getUsername());

        practice_recycler.setLayoutManager(new LinearLayoutManager(this));
        practice_adapter = new PracticeAdapter(quizzes, this);
        practice_recycler.setAdapter(practice_adapter);

        cancelbtn = findViewById(R.id.cancel_practice);
        cancelbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void startQuiz(Quiz quiz) {
        practiceSession = new PracticeSession(currStudent, quiz);
        Intent intent = new Intent(PracticeQuizActivity.this, QuizQuestionsActivity.class);
        intent.putExtra(CURRENT_PRACTICE_QUESTION, practiceSession.getNextQuestion());
        intent.putExtra(QUIZ_NAME, practiceSession.getQuizName());
        startActivityForResult(intent, QUESTION_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == QUESTION_CODE) {
            boolean correct;
            try {
                correct = (boolean) data.getExtras().getSerializable(CORRECT_ANSWER);
            } catch (Exception e) {
                finish(); // Exit the quiz after cancel
                return;
            }
            if (correct) {
                practiceSession.incrementScore();
            }
            if (practiceSession.getQuestionsRemaining() > 0) {
                Intent intent = new Intent(PracticeQuizActivity.this, QuizQuestionsActivity.class);
                intent.putExtra(CURRENT_PRACTICE_QUESTION, practiceSession.getNextQuestion());
                intent.putExtra(QUIZ_NAME, practiceSession.getQuizName());
                startActivityForResult(intent, QUESTION_CODE);
            } else {
                Statistic stat = practiceSession.getScore();
                DaoUtility.addStatistics(stat);
                createConfirm(stat);
            }
        }
    }

    //https://stackoverflow.com/questions/36747369/how-to-show-a-pop-up-in-android-studio-to-confirm-an-order
    private void  createConfirm(final Statistic stat) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Final score: " + stat.getScore()*100 + "%");
        builder.setPositiveButton("Exit",
            new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            }
        );
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public void onBackPressed() {
        // Do nothing
    }
}
