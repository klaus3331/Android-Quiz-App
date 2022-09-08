package edu.gatech.seclass.sdpvocabquiz.edu.gatech.seclass.sdpvocabquiz.designclasses;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import java.util.Date;

import edu.gatech.seclass.sdpvocabquiz.Database.DateTypeConverter;

import static edu.gatech.seclass.sdpvocabquiz.Database.DaoUtility.getStudentByUsername;

@Entity(indices = {@Index(value = "achieverName"), @Index(value = "quizName")},
        foreignKeys = {@ForeignKey(entity = Quiz.class,
                                  parentColumns = "name",
                                  childColumns = "quizName"),
                       @ForeignKey(entity = Student.class,
                                   parentColumns = "username",
                                   childColumns = "achieverName")})
public class Statistic {
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getQuizName() { return quizName; }
    public void setQuizName(String quizName) { this.quizName = quizName; }

    public String getAchieverName() { return achieverName; }
    public void setAchieverName(String achieverName) { this.achieverName = achieverName; }

    public void setScore(double score) { this.score = score; }
    public double getScore() {return this.score; }

    public void setDatetime(Date datetime) { this.datetime = datetime; }
    public Date getDatetime() {return this.datetime;}

    public void setAchievedBy(Student achievedBy) {this.achievedBy = achievedBy; }
    public Student getAchievedBy() { return achievedBy; }


    @PrimaryKey(autoGenerate = true)
    private int id;
    private String quizName; // foreign key to Quiz
    private String achieverName; // foreign key to Student
    private double score;
    @TypeConverters(value = DateTypeConverter.class)
    private Date datetime;
    @Ignore
    private Student achievedBy;

    // Constructor used by PracticeSession
    public Statistic(double score, Student achievedBy, Quiz quiz) {
        this.score = score;
        this.achievedBy = achievedBy;
        this.achieverName = achievedBy.getUsername();
        this.quizName = quiz.getName();
        this.datetime = new Date();
    }

    // Constructor used by DB
    public Statistic(String quizName, String achieverName, double score, Date datetime) {
        this.quizName = quizName;
        this.achieverName = achieverName;
        this.score = score;
        this.datetime = datetime;
        this.achievedBy = getStudentByUsername(this.achieverName);
    }

}
