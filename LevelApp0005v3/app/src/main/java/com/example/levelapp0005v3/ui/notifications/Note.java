package com.example.levelapp0005v3.ui.notifications;

import android.widget.ImageView;

public class Note {
    private int id;
    private String text;
    private int priority;

    private ImageView imageView;

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public Note(int id, String text, int priority, int imageView) {
        this.id = id;
        this.text = text;
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public int getPriority() {
        return priority;
    }

    public void setImageView(int stop_icon_152523) {
    }
}
