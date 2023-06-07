package com.example.levelapp0006v1.WorkWithNotes;

import java.util.ArrayList;
import java.util.Random;

public class DataBase {
    private ArrayList<Note> notes = new ArrayList<>();
    private static DataBase instance = null;
    public DataBase() {
        Random random = new Random();
        for (int i = 0; i < 15; i++) {
            Note note = new Note(i, "Note" + i, random.nextInt(3));
            notes.add(note);
        }
    }

    public static DataBase getInstance() {
        if (instance == null) {
            instance = new DataBase();
        }
        return instance;
    }

    public void add(Note note) {
        notes.add(note);
    }

    public ArrayList<Note> getNotes() {
        return notes;
    }

    public void remove(int id) {
        for (int i = 0; i < notes.size(); i++) {
            Note note = notes.get(i);
            if (note.getId() == id) {
                notes.remove(note);
            }
        }
    }
}
