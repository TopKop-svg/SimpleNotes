package com.example.levelapp0004v1.FinishTasks;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;

@Dao
public interface DeletedNotesDao {
    @Query("SELECT * FROM deleted_notes")
    Single<List<DeletedNote>> getDeletedNotes();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addDeletedNote(DeletedNote note);

    @Query("DELETE FROM deleted_notes WHERE id = :id")
    Completable removeDeletedNote(int id);
}
