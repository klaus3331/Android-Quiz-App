package edu.gatech.seclass.sdpvocabquiz.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import edu.gatech.seclass.sdpvocabquiz.R;

public class AddQuizFormActivity extends Activity {
    EditText quizWord;
    EditText correctDefinition;
    EditText incorrectDefinition1;
    EditText incorrectDefinition2;
    EditText incorrectDefinition3;
    Button okButton;
    Button resetButton;
    Button cancelButton;
    TextView progress;

    int currQuestionNumber;
    int totalNumQuestions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_quiz_form);

        Intent intent = getIntent();
        currQuestionNumber = (int)intent.getExtras().getSerializable(AddQuizActivity.CURR_QUESTION_NUM);
        totalNumQuestions = (int)intent.getExtras().getSerializable(AddQuizActivity.TOTAL_NUM_QUESTIONS);

        progress = findViewById(R.id.progress);
        progress.setText(currQuestionNumber + "/" + totalNumQuestions);

        quizWord = findViewById(R.id.quiz_word);
        correctDefinition = findViewById(R.id.correct_def);
        incorrectDefinition1 = findViewById(R.id.incorrect_def1);
        incorrectDefinition2 = findViewById(R.id.incorrect_def2);
        incorrectDefinition3 = findViewById(R.id.incorrect_def3);

        okButton = findViewById(R.id.ok_add_form_btn);
        okButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0){
                String word = quizWord.getText().toString();
                String correctDefinitionFinal = correctDefinition.getText().toString();
                String incorrectDef1 = incorrectDefinition1.getText().toString();
                String incorrectDef2 = incorrectDefinition2.getText().toString();
                String incorrectDef3 = incorrectDefinition3.getText().toString();
                if (word == null || word.isEmpty()
                        || correctDefinitionFinal == null || correctDefinitionFinal.isEmpty()
                        || incorrectDef1 == null || incorrectDef1.isEmpty()
                        || incorrectDef2 == null || incorrectDef2.isEmpty()
                        || incorrectDef3 == null || incorrectDef3.isEmpty()) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(AddQuizFormActivity.this);
                    builder.setMessage("Please leave no fields empty!");
                    builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                    return;
                }
                ArrayList<String> incorrectDefinitions = new ArrayList<>();
                incorrectDefinitions.add(incorrectDef1);
                incorrectDefinitions.add(incorrectDef2);
                incorrectDefinitions.add(incorrectDef3);

                Intent intent = new Intent();
                intent.putExtra(AddQuizActivity.WORD, word);
                intent.putExtra(AddQuizActivity.CORRECT_DEFINITION, correctDefinitionFinal);
                intent.putExtra(AddQuizActivity.INCORRECT_DEFINITIONS, incorrectDefinitions);
                setResult(AddQuizActivity.NEW_WORD_CODE, intent);
                finish();
            }
        });

        cancelButton = findViewById(R.id.cancel_form_btn);
        cancelButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0){
                // Return without setting new word details
                finish();
            }
        });

        resetButton = findViewById(R.id.reset_btn);
        resetButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0){
                quizWord.setText("");
                correctDefinition.setText("");
                incorrectDefinition1.setText("");
                incorrectDefinition2.setText("");
                incorrectDefinition3.setText("");
            }
        });
    }

    @Override
    public void onBackPressed() {
        // Do nothing
    }
}
