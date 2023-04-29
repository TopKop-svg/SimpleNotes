package com.example.levelapp0005v1.TaskLog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

import com.example.levelapp0005v1.R;

public class AddTask extends AppCompatActivity {

    private EditText editTextTask;

    private Switch switchAutoFail;

    private Switch switchTaskForTime;

    private Button buttonSave;
    private AddTaskViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        viewModel = new ViewModelProvider(this).get(AddTaskViewModel.class);
        viewModel.getShouldCloseScreen().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean sholdClose) {
                if (sholdClose){
                    finish();
                }
            }
        });
        initViews();
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveTask();
            }
        });

    }

    private void initViews() {
        editTextTask = findViewById(R.id.editTextTitle);
        switchAutoFail = findViewById(R.id.switch1);
        switchTaskForTime = findViewById(R.id.switch2);
        buttonSave = findViewById(R.id.buttonSave);
    }

    private void saveTask() {
        String text = editTextTask.getText().toString().trim();

        Task task = new Task(text);
        viewModel.saveTask(task);

    }

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, AddTask.class);
        return intent;
    }
}