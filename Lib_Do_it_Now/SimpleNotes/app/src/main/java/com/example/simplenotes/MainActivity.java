package com.example.simplenotes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private FloatingActionButton buttonAddNote;
    ExecutorService exService = Executors.newSingleThreadExecutor();
    private Database database = Database.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();




        buttonAddNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = AddNoteActivity.newIntent(MainActivity.this);
                startActivity(intent);
            }
        });


    }

    private void initViews() {
        recyclerView = findViewById(R.id.recyclerViewNotes);
        buttonAddNote = findViewById(R.id.buttonAddNote);
    }

    @Override
    protected void onResume() {
        showNotes();
        super.onResume();
    }

    @SuppressLint("MissingInflatedId")
    private void showNotes() {
        linearLayout.removeAllViews();
        for (Note note: database.getNotes()) {
            /*View view = getLayoutInflater().inflate(R.layout.note_item,
                    linearLayout,
                    false);*/
            CheckBox checkBox = view.findViewById(R.id.checkBoxNote);
            checkBox.setText(note.getTitle());
            onClickButtonOption(note, view);
            onClickButtonPlay(note, view);
            TextView textView = view.findViewById(R.id.textViewExplanation);
            textView.setText(note.getText());
            linearLayout.addView(view);     }
    }

    private void onClickButtonOption(Note note, View view) {
        ProgressBar progressBar = view.findViewById(R.id.progressBar);
        note.setButtonOption(view.findViewById(R.id.buttonOption));
        note.getButtonOption().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timerStart(note, view);
                ObjectAnimator animation = ObjectAnimator.ofInt(progressBar,
                        "progress",
                        0,
                        1);
                animation.setDuration(note.getTime());
                animation.setInterpolator(new LinearInterpolator());
                animation.start();
                if (note.getButtonOption().getText() == "X") {
                    note.getButtonOption().setText("V");
                    //progressBar.clearAnimation();

                } else {
                    note.getButtonOption().setText("X");

                }

            }
        });
    }

    private void onClickButtonPlay(Note note, View view) {
        note.setButtonPlay(view.findViewById(R.id.buttonPlay));
        ProgressBar progressBar = view.findViewById(R.id.progressBar);
        progressBar.setMax( note.getTime());
        note.getButtonPlay().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (note.getButtonPlay().getText() == "stop") {
                    note.getButtonPlay().setText("play");
                } else {
                    note.getButtonPlay().setText("stop");
                }

            }
        });
    }

    private void onLongClickOption () {
        //Под реализацию
    }

    private void timerStart(Note note, View view) {
        Context context = view.getContext();
        Intent intent = new Intent(context, AddNoteActivity.class);
        intent.putExtra("title", note.getTitle());
        intent.putExtra("text", note.getText());
        intent.putExtra("time", note.getTime());
        startActivity(intent);
        /*AddNoteActivity addNoteActivity = new AddNoteActivity();
        Intent intent = addNoteActivity.getOptionIntent(context,
                note.getTitle(),
                note.getText(),
                note.getTime());
        startActivity(intent);*/
    }



}