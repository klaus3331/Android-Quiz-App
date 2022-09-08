package edu.gatech.seclass.sdpvocabquiz.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.List;

import edu.gatech.seclass.sdpvocabquiz.Database.DaoUtility;
import edu.gatech.seclass.sdpvocabquiz.R;
import edu.gatech.seclass.sdpvocabquiz.edu.gatech.seclass.sdpvocabquiz.designclasses.Quiz;
import edu.gatech.seclass.sdpvocabquiz.adapters.RemoveAdapter;
import edu.gatech.seclass.sdpvocabquiz.edu.gatech.seclass.sdpvocabquiz.designclasses.Student;

public class RemoveQuizActivity extends Activity {

    private Student currStudent;

    RecyclerView remove_recycler;
    RecyclerView.Adapter remove_adapter;
    Button cancelbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.remove_quiz);

        Intent intent = getIntent();
        currStudent = (Student)intent.getExtras().getSerializable(MainMenuActivity.STUDENT);

        remove_recycler = this.<RecyclerView>findViewById(R.id.list_quizzes);

        List<Quiz> users = DaoUtility.getQuizzesByOwnerName(currStudent.getUsername());

        remove_recycler.setLayoutManager(new LinearLayoutManager(this));
        remove_adapter = new RemoveAdapter(users);
        remove_recycler.setAdapter(remove_adapter);

        cancelbtn = findViewById(R.id.cancel_remove);
        cancelbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    @Override
    public void onBackPressed() {
        // Do nothing
    }
}
