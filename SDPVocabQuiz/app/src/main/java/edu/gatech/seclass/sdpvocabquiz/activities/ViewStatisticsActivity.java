package edu.gatech.seclass.sdpvocabquiz.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.List;

import edu.gatech.seclass.sdpvocabquiz.Database.DaoUtility;
import edu.gatech.seclass.sdpvocabquiz.R;
import edu.gatech.seclass.sdpvocabquiz.adapters.ViewStatsAdapter;
import edu.gatech.seclass.sdpvocabquiz.edu.gatech.seclass.sdpvocabquiz.designclasses.Quiz;
import edu.gatech.seclass.sdpvocabquiz.edu.gatech.seclass.sdpvocabquiz.designclasses.Student;

public class ViewStatisticsActivity extends AppCompatActivity {

    private Student currStudent;

    RecyclerView stats_recycler;
    RecyclerView.Adapter stats_adapter;
    Button cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_stats);

        Intent intent = getIntent();
        currStudent = (Student)intent.getExtras().getSerializable(MainMenuActivity.STUDENT);

        stats_recycler = this.<RecyclerView>findViewById(R.id.stats_quiz_list);

        List<Quiz> quizzes = DaoUtility.getAllQuizzesOrderedByTakenDate(currStudent.getUsername());

        stats_recycler.setLayoutManager(new LinearLayoutManager(this));
        stats_adapter = new ViewStatsAdapter(quizzes, this);
        stats_recycler.setAdapter(stats_adapter);

        cancelButton = findViewById(R.id.cancel_select_stats);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void viewStatisticsForQuiz(String quiz_name) {
        Intent intent = new Intent(ViewStatisticsActivity.this, ScoresActivity.class);
        intent.putExtra(ScoresActivity.QUIZ, quiz_name);
        intent.putExtra(MainMenuActivity.STUDENT, currStudent);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        // Do nothing
    }

}
