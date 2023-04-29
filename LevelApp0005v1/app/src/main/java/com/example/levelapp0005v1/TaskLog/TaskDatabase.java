package com.example.levelapp0005v1.TaskLog;


import android.app.Application;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

@Database(entities = {Task.class}, version = 1)
public abstract class TaskDatabase extends RoomDatabase {

    private static TaskDatabase instance = null;

    private static final String DB_NAME = "tasks.db";

    public static TaskDatabase getInstance(Application application) {
        if (instance == null) {
            instance = Room.databaseBuilder(
                    application,
                    TaskDatabase.class,
                    DB_NAME
            )
                    .build();
        }
        return instance;
    }

    public abstract TasksDao tasksDao();

}
