package com.example.levelapp0005v1.TaskLog;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;

@Dao
public interface TasksDao {
    @Query("SELECT * FROM tasks")
    Single<List<Task>> getTasks();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void add(Task task);

    @Query("DELETE FROM tasks WHERE id = :id ")
    Completable remove(int id);
}
