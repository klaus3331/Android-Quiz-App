package edu.gatech.seclass.sdpvocabquiz.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import edu.gatech.seclass.sdpvocabquiz.R;
import edu.gatech.seclass.sdpvocabquiz.edu.gatech.seclass.sdpvocabquiz.designclasses.Student;

public class MainMenuActivity extends Activity {
    Button addQuizButton;
    Button removeQuizButton;
    Button practiceQuizButton;
    Button viewStatisticsButton;
    Button exitButton;

    Student currStudent;

    public static final String STUDENT = "STUDENT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);

        Intent intent = getIntent();
        currStudent = (Student)intent.getExtras().getSerializable(STUDENT);

        addQuizButton = findViewById(R.id.add_button);
        addQuizButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0){
                Intent intent=new Intent(MainMenuActivity.this,AddQuizActivity.class);
                intent.putExtra(STUDENT, currStudent);
                startActivity(intent);
            }
        });

        removeQuizButton = findViewById(R.id.select_remove);
        removeQuizButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0){
                Intent intent=new Intent(MainMenuActivity.this,RemoveQuizActivity.class);
                intent.putExtra(STUDENT, currStudent);
                startActivity(intent);
            }
        });

        practiceQuizButton = findViewById(R.id.practice_button);
        practiceQuizButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0){
                Intent intent=new Intent(MainMenuActivity.this,PracticeQuizActivity.class);
                intent.putExtra(STUDENT, currStudent);
                startActivity(intent);
            }
        });

        viewStatisticsButton = findViewById(R.id.view_stats);
        viewStatisticsButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0){
                Intent intent=new Intent(MainMenuActivity.this,ViewStatisticsActivity.class);
                intent.putExtra(STUDENT, currStudent);
                startActivity(intent);
            }
        });

        exitButton = findViewById(R.id.exit);
        exitButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0){
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        // Do nothing
    }
}
