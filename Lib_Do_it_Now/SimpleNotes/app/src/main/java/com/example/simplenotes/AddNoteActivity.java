package com.example.simplenotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddNoteActivity extends AppCompatActivity {
    private Button buttonSave;
    EditText editTextTitle, editTextExp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        initViews();

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveNote();
            }
        });

    }

    private void saveNote() {
        String title = editTextTitle.getText().toString().trim();
        String text = editTextExp.getText().toString().trim();
    }

    private void initViews() {
        buttonSave = findViewById(R.id.buttonSave);
        editTextTitle = findViewById(R.id.editTextTitle);
        editTextExp = findViewById(R.id.editTextExp);
    }

    public static Intent newIntent(Context context) {
        return new Intent(context, AddNoteActivity.class);
    }
}