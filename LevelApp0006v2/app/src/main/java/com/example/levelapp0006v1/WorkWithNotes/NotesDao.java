package com.example.levelapp0006v1.WorkWithNotes;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;
@Dao
public interface NotesDao {
    @Query("SELECT * FROM notes")
    Single<List<Note>> getNotes();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void add(Note note);

    @Query("DELETE FROM notes WHERE id = :id")
    Completable remove(int id);
}
