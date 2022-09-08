package edu.gatech.seclass.sdpvocabquiz.Database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import edu.gatech.seclass.sdpvocabquiz.edu.gatech.seclass.sdpvocabquiz.designclasses.Quiz;
import edu.gatech.seclass.sdpvocabquiz.edu.gatech.seclass.sdpvocabquiz.designclasses.Statistic;
import edu.gatech.seclass.sdpvocabquiz.edu.gatech.seclass.sdpvocabquiz.designclasses.Student;

@Dao
public interface AppDBDao {
    /*
    Quizzes
     */
    @Insert(onConflict = OnConflictStrategy.FAIL)
    long[] insertQuizzes(Quiz... quizzes);

    @Update
    int updateQuizzes(Quiz... quizzes);

    @Delete
    void deleteQuizzes(Quiz... users);

    @Query("SELECT * FROM Quiz WHERE name = :quizName")
    Quiz getQuizByName(String quizName);

    // Query to verify this quiz name is unique (returns 0 if unique)
    @Query("SELECT COUNT(*) FROM Quiz WHERE name = :quizName")
    int checkQuizNameUnique(String quizName);

    // Query to get all quizzes created by the specified owner
    @Query("SELECT * FROM Quiz WHERE ownerName = :ownerName")
    List<Quiz> getQuizzesByOwnerName (String ownerName);

    // Query to get all quizzes not created by the specified owner
    @Query("SELECT * FROM Quiz WHERE ownerName != :ownerName")
    List<Quiz> getQuizzesByOthers (String ownerName);

    //Query to get all quizzes
    @Query("SELECT * FROM Quiz")
    List<Quiz> getAllQuizes ();

    // Query to get all quizzes sorted by Date last played by the Student
    @Query("SELECT DISTINCT Quiz.* FROM Quiz LEFT JOIN Statistic ON Quiz.name=Statistic.quizName ORDER BY CASE WHEN Statistic.achieverName=:username THEN 1 ELSE 0 END DESC, Statistic.datetime DESC")
    List<Quiz> getAllQuizzesOrderedByTakenDate (String username);

    /*
    Students
     */

    @Insert(onConflict = OnConflictStrategy.FAIL)
    long[] addStudents(Student... students);

    @Update
    int updateStudents(Student... students);

    @Delete
    void deleteStudents(Student... students);

    // Query to check whether a student exists in the system given username
    // return 1 if found, 0 if not found
    @Query("SELECT COUNT(1) FROM Student WHERE username = :username")
    int checkStudentLogin(String username);

    // Query to verify this username is unique
    @Query("SELECT COUNT(*) FROM Student WHERE username = :username")
    int checkUserNameUnique(String username);

    @Query("SELECT * FROM Student WHERE username = :username")
    Student getStudentByUsername(String username);

    /*
    Statistics
     */
    @Insert(onConflict = OnConflictStrategy.FAIL)
    long[] addStatistics(Statistic... statistic);

    @Update
    int updateStatistics(Statistic... statistic);

    @Delete
    void deleteStatistics(Statistic... statistic);

    // Get all Statistics for a quiz
    @Query("SELECT * FROM Statistic WHERE quizName = :quizName")
    List<Statistic> getStatisticsByQuizName(String quizName);

    //Extra block of code used for testing
    @Query("SELECT * FROM Student")
    List<Student> getAllStudents();


}

