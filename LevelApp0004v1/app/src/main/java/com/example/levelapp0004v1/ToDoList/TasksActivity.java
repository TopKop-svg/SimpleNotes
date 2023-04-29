package com.example.levelapp0004v1.ToDoList;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.levelapp0004v1.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class TasksActivity extends AppCompatActivity {
    private RecyclerView recyclerViewNotes;
    private NotesAdapter notesAdapter;
    MainViewModel mainViewModel;
    private FloatingActionButton buttonAddNote;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        mainViewModel.getCount().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer count) {
                Toast.makeText(
                        TasksActivity.this, String.valueOf(count),
                        Toast.LENGTH_SHORT
                ).show();
            }
        });
        initViews();
        notesAdapter = new NotesAdapter();
        notesAdapter.setOnNoteClickListener(new NotesAdapter.OnNoteClickListener() {
            @Override
            public void onNoteClick(Note note) {
                mainViewModel.showCount();

            }
        });
        recyclerViewNotes.setAdapter(notesAdapter);
        mainViewModel.getNotes().observe(this, new Observer<List<Note>>() {
            @Override
            public void onChanged(List<Note> notes) {
                notesAdapter.setNotes(notes);
            }
        });

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(
                new ItemTouchHelper.SimpleCallback(0,
                        ItemTouchHelper.RIGHT | ItemTouchHelper.LEFT
                ) {
                    @Override
                    public boolean onMove(
                            @NonNull RecyclerView recyclerView,
                            @NonNull RecyclerView.ViewHolder viewHolder,
                            @NonNull RecyclerView.ViewHolder target
                    ) {
                        return false;
                    }

                    @Override
                    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                        int position = viewHolder.getAdapterPosition();
                        Note note = notesAdapter.getNotes().get(position);
                        mainViewModel.remove(note);
                    }
                });
        itemTouchHelper.attachToRecyclerView(recyclerViewNotes);

        buttonAddNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = AddNote.newIntent(TasksActivity.this);
                startActivity(intent);
            }
        });


    }

    private void initViews() {
        recyclerViewNotes = findViewById(R.id.recycleView);
        buttonAddNote = findViewById(R.id.buttonAddNote);

    }

    @Override
    protected void onResume() {
        super.onResume();
        mainViewModel.refreshList();
    }
}