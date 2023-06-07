package com.example.simplenotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private LinearLayout linearLayout, linearLayoutFinishNotes;
    private FloatingActionButton buttonAddNote;
    private ArrayList<Note> notes = new ArrayList<>();
    private  ArrayList<Note> notesFinish = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();



        for (int i = 0; i < 10; i++) {
            Note note = new Note(i, "Note " + i, "Non empty field \n" +
                    " just field note be empty");
            notes.add(note);
        }

        buttonAddNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = AddNoteActivity.newIntent(MainActivity.this);
                startActivity(intent);
            }
        });

        showNotes();
    }

    private void initViews() {
        linearLayout = findViewById(R.id.linearLayoutNotes);
        linearLayoutFinishNotes = findViewById(R.id.linearLayoutFinishNotes);
        buttonAddNote = findViewById(R.id.buttonAddNote);
    }

    private void showNotes() {
        for (Note note: notes) {
            View view = getLayoutInflater().inflate(R.layout.note_item,
                    linearLayout,
                    false);
            CheckBox checkBox = view.findViewById(R.id.checkBoxNote);
            checkBox.setText(note.getTitle());
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        readyNote(note);
                    }
                }
            });


            TextView textView = view.findViewById(R.id.textViewExplanation);
            textView.setText(note.getText());
            linearLayout.addView(view);
        }
    }

    private void readyNote(Note note) {
            notesFinish.add(note);
            notes.remove(note);
            View view = getLayoutInflater().inflate(R.layout.note_item,
                    linearLayoutFinishNotes,
                    false);
            linearLayoutFinishNotes.addView(view);
    }
}