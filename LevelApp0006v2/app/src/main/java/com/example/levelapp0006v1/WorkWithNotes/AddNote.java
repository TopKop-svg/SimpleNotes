package com.example.levelapp0006v1.WorkWithNotes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.levelapp0006v1.R;

public class AddNote extends AppCompatActivity {

    private EditText editTextNote;
    private RadioButton radioButtonLow;
    private RadioButton radioButtonMedium;
    private RadioButton radioButtonHight;
    private Button buttonSave;
    private AddNoteViewModel viewModel;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        viewModel = new ViewModelProvider(this).get(AddNoteViewModel.class);
        viewModel.getShouldCloseScreen().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean shouldClose) {
                if (shouldClose) {
                    finish();
                }
            }
        });
        initViews();
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveNote();
            }
        });
    }

    private void initViews() {
        editTextNote  = findViewById(R.id.editTextNote);
        radioButtonLow = findViewById(R.id.RadioButtonLow);
        radioButtonMedium = findViewById(R.id.RadioButtonMedium);
        radioButtonHight = findViewById(R.id.RadioButtonHight);
        buttonSave = findViewById(R.id.buttonSave);
    }

    private void saveNote() {
        String text = editTextNote.getText().toString().trim();
        int priority = getPriority();

        Note note = new Note(text, priority);
        viewModel.saveNote(note);


    }

    private int getPriority() {
        int priority;
        if (radioButtonLow.isChecked()) {
            priority = 0;
        } else if (radioButtonMedium.isChecked()) {
            priority = 1;
        } else {
            priority = 2;
        }
        return priority;
    }

    public static Intent newIntent(Context context) {

        Intent intent = new Intent(context, AddNote.class);
        return intent;
    }
}