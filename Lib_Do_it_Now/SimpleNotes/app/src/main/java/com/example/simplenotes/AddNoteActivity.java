package com.example.simplenotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;

public class AddNoteActivity extends AppCompatActivity {
    private Button buttonSave;
     private int time;
     private int id;
     String title, text;
     private NumberPicker numberPickerHours, numberPickerMin;
    private Database database = Database.getInstance();
    EditText editTextTitle, editTextExp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        initViews();
        initNumberPicker();
        editTextTitle.setText(getIntent().getStringExtra("title"));
        editTextExp.setText(getIntent().getStringExtra("text"));
        this.time = getIntent().getIntExtra("time", 0);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveNote();
            }
        });

    }



    private void saveNote() {
        title = editTextTitle.getText().toString().trim();
        text = editTextExp.getText().toString().trim();
        int id = database.getNotes().size();
        Note note = new Note(id, title, text);
        database.add(note);

        finish();
    }

    private void saveNote(int id) {
        String title = editTextTitle.getText().toString().trim();
        String text = editTextExp.getText().toString().trim();
        this.id = id;
    }



    private void initViews() {
        buttonSave = findViewById(R.id.buttonSave);
        editTextTitle = findViewById(R.id.editTextTitle);
        editTextExp = findViewById(R.id.editTextExp);
        numberPickerHours = findViewById(R.id.numberPickerHour);
        numberPickerMin = findViewById(R.id.numberPickerMinute);
    }

    private void initNumberPicker() {
        numberPickerHours.setMinValue(0);
        numberPickerHours.setMaxValue(23);

        numberPickerMin.setMinValue(0);
        numberPickerMin.setMaxValue(59);

    }

    public static Intent newIntent(Context context) {

        return new Intent(context, AddNoteActivity.class);
    }

    public Intent getOptionIntent(Context context, String title, String text, int time){
        this.time = time;
        this.title = title;
        this.text = text;
        return new Intent(context, AddNoteActivity.class);
    }

    public void setEditTextTitle(EditText editTextTitle) {
        this.editTextTitle = editTextTitle;
    }

    public void setEditTextExp(EditText editTextExp) {
        this.editTextExp = editTextExp;
    }

    public void findId(Note note) {
        for(Note n: database.getNotes()) {
            if (n.getId() == note.getId()) {
                database.remove(n.getId());
            } else {

                database.add(note);
            }
        }
    }


}