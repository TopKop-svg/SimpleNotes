package com.example.todolisttwo;

import java.util.ArrayList;

public class Database {
    private ArrayList<Note> notes = new ArrayList<>();
    public void add(Note note) {
        notes.add(note);
    }

    public void remove(int id) {
        for (int i = 0; i < notes.size(); i++) {
            Note note = notes.get(i);
            if (note.getId() == id){
                notes.remove(note);
            }
        }
    }
}
