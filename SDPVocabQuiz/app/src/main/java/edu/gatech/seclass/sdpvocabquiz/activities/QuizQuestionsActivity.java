package edu.gatech.seclass.sdpvocabquiz.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.List;

import edu.gatech.seclass.sdpvocabquiz.R;
import edu.gatech.seclass.sdpvocabquiz.edu.gatech.seclass.sdpvocabquiz.designclasses.PracticeQuestion;

public class QuizQuestionsActivity extends Activity {
    RadioButton definition1;
    RadioButton definition2;
    RadioButton definition3;
    RadioButton definition4;

    TextView quizName;
    TextView word;
    TextView def1Text;
    TextView def2Text;
    TextView def3Text;
    TextView def4Text;

    Button okButton;
    Button cancelButton;

    PracticeQuestion currQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_questions);

        Intent intent = getIntent();
        currQuestion = (PracticeQuestion)intent.getExtras().getSerializable(PracticeQuizActivity.CURRENT_PRACTICE_QUESTION);

        quizName = findViewById(R.id.quiz_name);
        quizName.setText((String)intent.getExtras().getSerializable(PracticeQuizActivity.QUIZ_NAME));

        word = findViewById(R.id.quiz_word);
        word.setText(currQuestion.getWord());
        List<String> choices = currQuestion.getChoices();
        def1Text = findViewById(R.id.answer1);
        def1Text.setText(choices.get(0));
        def2Text = findViewById(R.id.answer2);
        def2Text.setText(choices.get(1));
        def3Text = findViewById(R.id.textView31);
        def3Text.setText(choices.get(2));
        def4Text = findViewById(R.id.textView32);
        def4Text.setText(choices.get(3));

        definition1 = findViewById(R.id.definition1);
        definition1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleButtons(definition1);
            }
        });
        definition2 = findViewById(R.id.definition2);
        definition2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleButtons(definition2);
            }
        });
        definition3 = findViewById(R.id.definition3);
        definition3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleButtons(definition3);
            }
        });
        definition4 = findViewById(R.id.definition4);
        definition4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleButtons(definition4);
            }
        });

        okButton = findViewById(R.id.ok_questions_btn);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!definition1.isChecked() && !definition2.isChecked()
                        && !definition3.isChecked() && !definition4.isChecked()) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(QuizQuestionsActivity.this);
                    builder.setMessage("Please select one of the definitions!");
                    builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();

                    return;
                }
                String answer;
                if (definition1.isChecked()) {
                    answer = def1Text.getText().toString();
                } else if (definition2.isChecked()) {
                    answer = def2Text.getText().toString();
                } else if (definition3.isChecked()) {
                    answer = def3Text.getText().toString();
                } else { //definition4.isChecked()
                    answer = def4Text.getText().toString();
                }
                createConfirm(currQuestion.checkAnswer(answer));
            }
        });

        cancelButton = findViewById(R.id.cancel_questions_btn);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Return without setting correct or not, thereby canceling the entire practice session
                finish();
            }
        });
    }

    private void toggleButtons(RadioButton button) {
        definition1.setChecked(false);
        definition2.setChecked(false);
        definition3.setChecked(false);
        definition4.setChecked(false);
        button.setChecked(true);
    }

    //https://stackoverflow.com/questions/36747369/how-to-show-a-pop-up-in-android-studio-to-confirm-an-order
    private void  createConfirm(final boolean correct) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        if (correct) {
            builder.setMessage("Correct!");
        } else {
            builder.setMessage("Incorrect.  Correct answer: " + currQuestion.getCorrectDefinition());
        }
        builder.setPositiveButton("Next Question",
            new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent();
                    intent.putExtra(PracticeQuizActivity.CORRECT_ANSWER, correct);
                    setResult(PracticeQuizActivity.QUESTION_CODE, intent);
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
