package edu.gatech.seclass.sdpvocabquiz.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

import edu.gatech.seclass.sdpvocabquiz.Database.DaoUtility;
import edu.gatech.seclass.sdpvocabquiz.R;
import edu.gatech.seclass.sdpvocabquiz.edu.gatech.seclass.sdpvocabquiz.designclasses.Quiz;
import edu.gatech.seclass.sdpvocabquiz.edu.gatech.seclass.sdpvocabquiz.designclasses.SolutionSpace;
import edu.gatech.seclass.sdpvocabquiz.edu.gatech.seclass.sdpvocabquiz.designclasses.Student;

public class AddQuizActivity extends Activity {
    EditText quizName;
    EditText description;
    EditText numWords;

    Button okButton;
    Button cancelButton;

    Student currStudent;

    String errorMessage;

    private String quizNameFinal;
    private String descriptionFinal;
    private SolutionSpace solutionSpaceFinal;
    private int numWordsFinal;
    private int currNumWords;

    public static final int NEW_WORD_CODE = 0;
    public static final String WORD = "WORD";
    public static final String CORRECT_DEFINITION = "CORRECT_DEFINITION";
    public static final String INCORRECT_DEFINITIONS = "INCORRECT_DEFINITIONS";

    public static final String CURR_QUESTION_NUM = "CURR_QUESTION_NUM";
    public static final String TOTAL_NUM_QUESTIONS = "TOTAL_NUM_QUESTIONS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_quiz);

        Intent intent = getIntent();
        currStudent = (Student) intent.getExtras().getSerializable(MainMenuActivity.STUDENT);

        quizName = findViewById(R.id.quiz_name);
        description = findViewById(R.id.description);
        numWords = findViewById(R.id.editText3);

        okButton = findViewById(R.id.ok_add_btn);
        okButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                quizNameFinal = quizName.getText().toString();

                if (DaoUtility.checkQuizNameUnique(quizNameFinal) == 0) {
                    descriptionFinal = description.getText().toString();
                    numWordsFinal = Integer.parseInt(numWords.getText().toString());

                    //validates that number entered is between 1 and 10
                    if (numWordsFinal < 1 || numWordsFinal > 10) {
                        errorMessage = "Only numbers from 1 to 10 please";
                        showAlert(errorMessage);
                    }else {
                        solutionSpaceFinal = new SolutionSpace();
                        currNumWords = 0;
                        // Start looping add words
                        Intent intent = new Intent(AddQuizActivity.this, AddQuizFormActivity.class);
                        intent.putExtra(CURR_QUESTION_NUM, 1);
                        intent.putExtra(TOTAL_NUM_QUESTIONS, numWordsFinal);
                        startActivityForResult(intent, NEW_WORD_CODE);
                    }
                } else {
                    errorMessage = "Quiz name already exists.";
                    showAlert(errorMessage);
                }

            }
        });

        cancelButton = findViewById(R.id.cancel_add_btn);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                // Return without setting new quiz object
                finish();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == NEW_WORD_CODE) {
            String word;
            String correctDefinition;
            List<String> incorrectDefinitions;
            try {
                word = (String) data.getExtras().getSerializable(WORD);
                correctDefinition = (String) data.getExtras().getSerializable(CORRECT_DEFINITION);
                incorrectDefinitions = (List<String>) data.getExtras().getSerializable(INCORRECT_DEFINITIONS);
            } catch (Exception e) {
                // Cancel case, Return without setting new quiz object
                finish();
                return;
            }
            if (word == null || correctDefinition == null || incorrectDefinitions == null) {
                // Cancel case, Return without setting new quiz object
                finish();
                return;
            }
            solutionSpaceFinal.addWord(word, correctDefinition, incorrectDefinitions);
            currNumWords++;
            if (currNumWords < numWordsFinal) {
                // Continue looping to add new words
                Intent intent = new Intent(AddQuizActivity.this, AddQuizFormActivity.class);
                intent.putExtra(CURR_QUESTION_NUM, currNumWords + 1);
                intent.putExtra(TOTAL_NUM_QUESTIONS, numWordsFinal);
                startActivityForResult(intent, NEW_WORD_CODE);
            } else {
                Quiz quiz = new Quiz(quizNameFinal, descriptionFinal, solutionSpaceFinal, currStudent);
                DaoUtility.addQuiz(quiz);
                finish();
            }
        }
    }

    @Override
    public void onBackPressed() {
        // Do nothing
    }

    private void showAlert(String msg) {
        AlertDialog.Builder builder = new AlertDialog.Builder(AddQuizActivity.this);
        builder.setMessage(msg);
        builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}