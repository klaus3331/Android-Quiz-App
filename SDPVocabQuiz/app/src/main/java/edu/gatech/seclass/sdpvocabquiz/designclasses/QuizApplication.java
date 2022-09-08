package edu.gatech.seclass.sdpvocabquiz.edu.gatech.seclass.sdpvocabquiz.designclasses;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import edu.gatech.seclass.sdpvocabquiz.Database.AppDatabase;
import edu.gatech.seclass.sdpvocabquiz.Database.DaoUtility;
import edu.gatech.seclass.sdpvocabquiz.R;
import edu.gatech.seclass.sdpvocabquiz.activities.MainMenuActivity;
import edu.gatech.seclass.sdpvocabquiz.activities.RegisterStudentActivity;

public class QuizApplication extends AppCompatActivity {
    Button loginButton;
    Button registerButton;
    EditText usernameField;

    public static final int REGISTER_STUDENT_CODE = 0;
    public static final String NEW_STUDENT = "NEW_STUDENT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        // initiate AppDB
        AppDatabase.getAppDatabase(getApplicationContext());

        usernameField = findViewById(R.id.editText6);

        loginButton = findViewById(R.id.login_button);
        loginButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0){
                Student student = login(usernameField.getText().toString());
                if (student != null) {
                    Intent intent = new Intent(QuizApplication.this, MainMenuActivity.class);
                    intent.putExtra(MainMenuActivity.STUDENT, student);
                    startActivity(intent);
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(QuizApplication.this);
                    builder.setMessage("Invalid username!");
                    builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
            }
        });

        registerButton = findViewById(R.id.reg_new_student);
        registerButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0){
                Intent intent = new Intent(QuizApplication.this, RegisterStudentActivity.class);
                startActivityForResult(intent, REGISTER_STUDENT_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REGISTER_STUDENT_CODE) {
            Student newStudent;
            try {
                newStudent = (Student) data.getExtras().getSerializable(NEW_STUDENT);
            } catch (Exception e) {
                return;
            }
            if (newStudent == null) {
                return;
            }
            register(newStudent);
        }
    }

    public Student login(String username) {
        int isRegistered = DaoUtility.login(username);
        if(isRegistered == 1){
            return DaoUtility.getStudentByUsername(username);
        } else{
            return  null;
        }
    }

    public void register(Student student) {
        DaoUtility.register(student); // access DB to register student
        Intent intent = new Intent(QuizApplication.this, MainMenuActivity.class);
        intent.putExtra(MainMenuActivity.STUDENT, student);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        AppDatabase.destroyInstance();
        super.onDestroy();
    }
}

