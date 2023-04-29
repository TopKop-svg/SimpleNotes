package com.example.levelapp0004v1.FinishTasks;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
@Entity(tableName = "deleted_notes")
public class DeletedNote {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String text;
    private int priority;

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public int getPriority() {
        return priority;
    }

    public DeletedNote(int id, String text, int priority) {
        this.id = id;
        this.text = text;
        this.priority = priority;
    }

    @Ignore
    public DeletedNote(String text, int priority) {
        this.text = text;
        this.priority = priority;
    }
}
