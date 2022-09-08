package edu.gatech.seclass.sdpvocabquiz.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import edu.gatech.seclass.sdpvocabquiz.Database.DaoUtility;
import edu.gatech.seclass.sdpvocabquiz.R;
import edu.gatech.seclass.sdpvocabquiz.edu.gatech.seclass.sdpvocabquiz.designclasses.Statistic;
import edu.gatech.seclass.sdpvocabquiz.edu.gatech.seclass.sdpvocabquiz.designclasses.Student;

public class ScoresActivity extends Activity {

    TextView first_score;
    TextView date_first;

    TextView highest_score;
    TextView date_highest;

    TextView name_100_1;
    TextView date_100_1;

    TextView name_100_2;
    TextView date_100_2;

    TextView name_100_3;
    TextView date_100_3;

    Button okButton;

    String quizName;
    Student currStudent;

    public static final String QUIZ = "QUIZ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scores);

        Intent intent = getIntent();
        quizName = (String)intent.getExtras().getSerializable(QUIZ);
        currStudent = (Student)intent.getExtras().getSerializable(MainMenuActivity.STUDENT);

        okButton = findViewById(R.id.ok_stats);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        List<Statistic> statisticList = DaoUtility.getStatisticsByQuizName(quizName);
        Collections.sort(statisticList, new Comparator<Statistic>() {
            @Override
            public int compare(Statistic o1, Statistic o2) {
                return o1.getDatetime().compareTo(o2.getDatetime());
            }
        });
        Statistic firstByCurrent = null;
        Statistic highByCurrent = null;
        Statistic firstStudent100 = null;
        Statistic secondStudent100 = null;
        Statistic thirdStudent100 = null;
        for (Statistic stat : statisticList) {
            if (firstByCurrent == null && stat.getAchievedBy().getUsername().equals(currStudent.getUsername())) {
                firstByCurrent = stat;
                highByCurrent = stat;
            }
            if (highByCurrent != null && stat.getAchievedBy().getUsername().equals(currStudent.getUsername())
                    && stat.getScore() > highByCurrent.getScore()) {
                highByCurrent = stat;
            }
            if (stat.getScore() == 1.0) {
                if (firstStudent100 == null) {
                    firstStudent100 = stat;
                } else if (secondStudent100 == null) {
                    secondStudent100 = stat;
                } else if (thirdStudent100 == null) {
                    thirdStudent100 = stat;
                }
            }
        }
        List<Statistic> oneHundreds = new ArrayList<>();
        if (firstStudent100 != null) {
            oneHundreds.add(firstStudent100);
        }
        if (secondStudent100 != null) {
            oneHundreds.add(secondStudent100);
        }
        if (thirdStudent100 != null) {
            oneHundreds.add(thirdStudent100);
        }
        Collections.sort(oneHundreds, new Comparator<Statistic>() {
            @Override
            public int compare(Statistic o1, Statistic o2) {
                return o1.getAchieverName().compareTo(o2.getAchieverName());
            }
        });
        first_score = findViewById(R.id.first_score);
        date_first = findViewById(R.id.date_first);
        if (firstByCurrent != null) {
            first_score.setText(firstByCurrent.getScore()*100 + "%");
            date_first.setText(firstByCurrent.getDatetime().toString());
        }
        highest_score = findViewById(R.id.highest_score);
        date_highest = findViewById(R.id.date_highest);
        if (highByCurrent != null) {
            highest_score.setText(highByCurrent.getScore()*100 + "%");
            date_highest.setText(highByCurrent.getDatetime().toString());
        }
        name_100_1 = findViewById(R.id.name_100);
        date_100_1 = findViewById(R.id.date_100);
        if (oneHundreds.size() > 0) {
            name_100_1.setText(oneHundreds.get(0).getAchieverName());
            date_100_1.setText(oneHundreds.get(0).getDatetime().toString());
        }
        name_100_2 = findViewById(R.id.name_100_2);
        date_100_2 = findViewById(R.id.date_100_2);
        if (oneHundreds.size() > 1) {
            name_100_2.setText(oneHundreds.get(1).getAchieverName());
            date_100_2.setText(oneHundreds.get(1).getDatetime().toString());
        }
        name_100_3 = findViewById(R.id.name_100_3);
        date_100_3 = findViewById(R.id.date_100_3);
        if (oneHundreds.size() > 2) {
            name_100_3.setText(oneHundreds.get(2).getAchieverName());
            date_100_3.setText(oneHundreds.get(2).getDatetime().toString());
        }
    }

    @Override
    public void onBackPressed() {
        // Do nothing
    }
}
