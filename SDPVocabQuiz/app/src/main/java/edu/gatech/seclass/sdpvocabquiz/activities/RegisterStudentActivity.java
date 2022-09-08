package edu.gatech.seclass.sdpvocabquiz.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import edu.gatech.seclass.sdpvocabquiz.Database.DaoUtility;
import edu.gatech.seclass.sdpvocabquiz.R;
import edu.gatech.seclass.sdpvocabquiz.edu.gatech.seclass.sdpvocabquiz.designclasses.QuizApplication;
import edu.gatech.seclass.sdpvocabquiz.edu.gatech.seclass.sdpvocabquiz.designclasses.SeniorityLevel;
import edu.gatech.seclass.sdpvocabquiz.edu.gatech.seclass.sdpvocabquiz.designclasses.Student;

public class RegisterStudentActivity extends Activity {
    EditText usernameField;
    Spinner seniorityField;
    EditText emailField;
    EditText majorField;
    Button okButton;
    Button cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_new_student);

        usernameField = findViewById(R.id.username);
        seniorityField = findViewById(R.id.seniority);
        seniorityField.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, SeniorityLevel.values()));
        emailField = findViewById(R.id.email);
        majorField = findViewById(R.id.major);

        okButton = findViewById(R.id.ok_register);

        okButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0){
                String username = usernameField.getText().toString();
                SeniorityLevel seniorityLevel = (SeniorityLevel)seniorityField.getSelectedItem();
                String email = emailField.getText().toString();
                String major = majorField.getText().toString();
                int isUniqueNewUsername = DaoUtility.checkUserNameUnique(username);

                if (username.isEmpty() || username == null || seniorityLevel == null
                        || email.isEmpty() || email == null || major.isEmpty() || major == null){
                    AlertDialog.Builder builder = new AlertDialog.Builder(RegisterStudentActivity.this);
                    builder.setMessage("Please fill out all fields!");
                    builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();

                }else {

                    if (isUniqueNewUsername == 0) {
                        Student student = new Student(username, major, seniorityLevel, email);
                        Intent intent = new Intent();
                        intent.putExtra(QuizApplication.NEW_STUDENT, student);
                        setResult(QuizApplication.REGISTER_STUDENT_CODE, intent);
                        finish();
                    } else {

                        AlertDialog.Builder builder = new AlertDialog.Builder(RegisterStudentActivity.this);
                        builder.setMessage("username already exits!");
                        builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }
                }
            }
        });

        cancelButton = findViewById(R.id.cancel_register);
        cancelButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0){
                // Return without setting new student object
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        // Do nothing
    }
}
