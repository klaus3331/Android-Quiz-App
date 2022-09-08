package edu.gatech.seclass.sdpvocabquiz.Database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import edu.gatech.seclass.sdpvocabquiz.edu.gatech.seclass.sdpvocabquiz.designclasses.Quiz;
import edu.gatech.seclass.sdpvocabquiz.edu.gatech.seclass.sdpvocabquiz.designclasses.Statistic;
import edu.gatech.seclass.sdpvocabquiz.edu.gatech.seclass.sdpvocabquiz.designclasses.Student;

/* A singleton for Database. Make sure that only one DB instance is created */


// Reference: https://medium.com/@ajaysaini.official/building-database-with-room-persistence-library-ecf7d0b8f3e9
@Database(entities = {Student.class,Quiz.class,Statistic.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public static AppDatabase getINSTANCE() {
        return INSTANCE;
    }

    private static AppDatabase INSTANCE;

    public abstract AppDBDao appDBDao();

    public static AppDatabase getAppDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "user-database")
                            .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

}

