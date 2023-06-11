package com.example.simplenotes;

import android.widget.Button;

public class Note {
    private int id;
    private String Title;
    private String text;

    private int progressTime;
    private Button buttonOption, buttonPlay;


    public Note(int id, String title, String text) {
        this.id = id;
        Title = title;
        this.text = text;
    }

    public Note(int id, String title, String text, int time) {
        this.id = id;
        Title = title;
        this.text = text;
        this.progressTime = time;
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

    public int getTime() {
        return progressTime;
    }

    public void setProgressTime(int progressTime) {
        this.progressTime = progressTime;
    }

    public Button getButtonOption() {
        return buttonOption;
    }

    public void setButtonOption(Button buttonOption) {
        this.buttonOption = buttonOption;
    }

    public Button getButtonPlay() {
        return buttonPlay;
    }

    public void setButtonPlay(Button buttonPlay) {
        this.buttonPlay = buttonPlay;
    }
}
