package com.example.simplenotes;

public class Note {
    private int id;
    private String Title;
    private String text;



    public Note(int id, String title, String text) {
        this.id = id;
        Title = title;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return Title;
    }

    public String getText() {
        return text;
    }
}
