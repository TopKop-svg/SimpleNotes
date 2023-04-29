package com.example.levelapp0004v1.FinishTasks;

import androidx.room.Database;

import com.example.levelapp0004v1.ToDoList.Note;
import com.example.levelapp0004v1.ToDoList.NotesDao;
@Database(entities = {Note.class, DeletedNote.class}, version = 1)
public abstract class DeleteNoteDatabase {
    public abstract NotesDao notesDao();

    public abstract DeletedNotesDao deletedNotesDao();
}
