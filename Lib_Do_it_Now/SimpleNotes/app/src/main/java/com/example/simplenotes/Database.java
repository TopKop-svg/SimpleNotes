package com.example.simplenotes;

import java.util.ArrayList;

public class Database {
    private ArrayList<Note> notes = new ArrayList<>();
    private static  Database instance = null;

    public static Database getInstance() {
        if (instance == null) {
            instance =  new Database();
        }
        return instance;
    }

    private  Database() {
        for (int i = 0; i < 10; i++) {
            Note note = new Note(i, "Note " + i, "Non empty field \n" +
                    " just field note be empty", 100);
            notes.add(note);
        }
    }

    public void add(Note note) {
        /*for(Note n: notes) {
            if (note.getTitle().equals(n.getTitle())) {
                Database.instance.remove(n.getId());
            }
        }*/
        notes.add(note);
    }

    public void remove(int id) {
        for(Note note: notes) {
            if (note.getId() == id) {
                notes.remove(note);
            }
        }
    }

    public ArrayList<Note> getNotes() {
        return new ArrayList<>(notes);
    }
}
