package edu.gatech.seclass.sdpvocabquiz.Database;

/* This class defines some utility for accessing Dao*/

import java.util.List;

import edu.gatech.seclass.sdpvocabquiz.edu.gatech.seclass.sdpvocabquiz.designclasses.Quiz;
import edu.gatech.seclass.sdpvocabquiz.edu.gatech.seclass.sdpvocabquiz.designclasses.Statistic;
import edu.gatech.seclass.sdpvocabquiz.edu.gatech.seclass.sdpvocabquiz.designclasses.Student;

public final class DaoUtility {
    private final static AppDatabase db = AppDatabase.getINSTANCE();

    private DaoUtility(){
    }

    public static Student getStudentByUsername(final String username){
        RunDatabaseOperation<Student> runDBObj = new RunDatabaseOperation<> (new DatabaseOperation() {
            @Override
            public void run() {
                value = db.appDBDao().getStudentByUsername(username);
            }
        });

        return runDBObj.execute();
    }

    public static int checkUserNameUnique(final String username){
        RunDatabaseOperation<Integer> runDBObj = new RunDatabaseOperation<> (new DatabaseOperation() {
            @Override
            public void run() {
                value = db.appDBDao().checkUserNameUnique(username);
            }
        });

        return runDBObj.execute();
    }
    public static int checkQuizNameUnique(final String quizName){
        RunDatabaseOperation<Integer> runDBObj = new RunDatabaseOperation<> (new DatabaseOperation() {
            @Override
            public void run() {
                value = db.appDBDao().checkQuizNameUnique(quizName);
            }
        });

        return runDBObj.execute();
    }


    public static List<Statistic> getStatisticsByQuizName(final String quizname){
        RunDatabaseOperation<List<Statistic>> runDBObj = new RunDatabaseOperation<> (new DatabaseOperation() {
            @Override
            public void run() {
                value = db.appDBDao().getStatisticsByQuizName(quizname);
            }
        });

        return runDBObj.execute();
    }

    public static void addStatistics(final Statistic statistic){
        RunDatabaseOperation<Long[]> runDBObj = new RunDatabaseOperation<> (new DatabaseOperation() {
            @Override
            public void run() {
                value = db.appDBDao().addStatistics(statistic);
            }
        });

        runDBObj.execute();
    }

    public static void addQuiz(final Quiz quiz){
        RunDatabaseOperation<Integer> runDBObj = new RunDatabaseOperation<> (new DatabaseOperation() {
            @Override
            public void run() {
                value = db.appDBDao().insertQuizzes(quiz);
            }
        });

        runDBObj.execute();
    }

    public static void removeQuiz(final Quiz quiz){
        RunDatabaseOperation<Integer> runDBObj = new RunDatabaseOperation<> (new DatabaseOperation() {
            @Override
            public void run() {
                db.appDBDao().deleteQuizzes(quiz);
            }
        });

        runDBObj.execute();
    }

    public static Quiz getQuizByName(final String quizName){
        RunDatabaseOperation<Quiz> runDBObj = new RunDatabaseOperation<> (new DatabaseOperation() {
            @Override
            public void run() {
                value = db.appDBDao().getQuizByName(quizName);
            }
        });

        return runDBObj.execute();
    }

    public static List<Quiz> getQuizzesByOwnerName(final String ownerName){
        RunDatabaseOperation<List<Quiz>> runDBObj = new RunDatabaseOperation<> (new DatabaseOperation() {
            @Override
            public void run() {
                value = db.appDBDao().getQuizzesByOwnerName(ownerName);
            }
        });

        return runDBObj.execute();
    }

    public static List<Quiz> getQuizzesByOthers(final String ownerName){
        RunDatabaseOperation<List<Quiz>> runDBObj = new RunDatabaseOperation<> (new DatabaseOperation() {
            @Override
            public void run() {
                value = db.appDBDao().getQuizzesByOthers(ownerName);
            }
        });

        return runDBObj.execute();
    }

    public static List<Quiz> getAllQuizzesOrderedByTakenDate(final String username){
        RunDatabaseOperation<List<Quiz>> runDBObj = new RunDatabaseOperation<> (new DatabaseOperation() {
            @Override
            public void run() {
                value = db.appDBDao().getAllQuizzesOrderedByTakenDate(username);
            }
        });

        return runDBObj.execute();
    }

    public static int login(final String username){
//        int value = db.appDBDao().checkStudentLogin(username);
        RunDatabaseOperation<Integer> runDBObj = new RunDatabaseOperation<> (new DatabaseOperation() {
            @Override
            public void run() {
                value = db.appDBDao().checkStudentLogin(username);
            }
        });

        return runDBObj.execute();
//        return value;
    }

    public static void register(final Student student){
        RunDatabaseOperation<Long[]> runDBObj = new RunDatabaseOperation<> (new DatabaseOperation() {
            @Override
            public void run() {
                    value = db.appDBDao().addStudents(student);
            }
        });

        runDBObj.execute();
    }

    //Extra block of code used for testing
    public static List<Student> getAllStudents(){
        RunDatabaseOperation<List<Student>> runDBObj = new RunDatabaseOperation<> (new DatabaseOperation() {
            @Override
            public void run() {
                value = db.appDBDao().getAllStudents();
            }
        });

        return runDBObj.execute();
    }

    public static List<Quiz> getAllQuizes(){
        RunDatabaseOperation<List<Quiz>> runDBObj = new RunDatabaseOperation<> (new DatabaseOperation(){
            @Override
            public void run() {
                value = db.appDBDao().getAllQuizes();
            }
        });
        return runDBObj.execute();
    }
}
