package com.example.levelapp0006v3;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.levelapp0006v3.WorkWithNotes.AddNote;
import com.example.levelapp0006v3.WorkWithNotes.Note;
import com.example.levelapp0006v3.WorkWithNotes.NotesAdapter;
import com.example.levelapp0006v3.WorkWithNotes.TaskFragmentViewModel;
import com.example.levelapp0006v3.databinding.FragmentTaskBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class TaskFragment extends Fragment {

    private RecyclerView recyclerViewNotes;
    private FragmentTaskBinding binding;
    private NotesAdapter notesAdapter;
    TaskFragmentViewModel viewModelNotes;
    private FloatingActionButton buttonAddNote;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @SuppressLint("FragmentLiveDataObserve")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTaskBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        initViews(root);
        Context context = this.getContext();
        notesAdapter = new NotesAdapter();
        notesAdapter.setOnNoteClickListener(new NotesAdapter.OnNoteClickListener() {
            @Override
            public void onNoteClick(Note note) {

            }
        });

        viewModelNotes = new ViewModelProvider(this).get(TaskFragmentViewModel.class);

        //Замена TaskFragment на getViewLifecycleOwner
        initViews(root);
        NotesSetOnClick(viewModelNotes);

        viewModelNotes.getNotes().observe(this, new Observer<List<Note>>() {
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
                        viewModelNotes.remove(note);
                    }
                });

        itemTouchHelper.attachToRecyclerView(recyclerViewNotes);
        buttonAddNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.d("TaskFragment", "Tap to button");
                Intent intent = AddNote.newIntent(context );
                startActivity(intent);
            }
        });

        return inflater.inflate(R.layout.fragment_task, container, false);


    }

    private void initViews(View view) {
        recyclerViewNotes = view.findViewById(R.id.recycleView);
        buttonAddNote = view.findViewById(R.id.buttonAddNote);
        notesAdapter = new NotesAdapter();

    }

    private void NotesSetOnClick(TaskFragmentViewModel taskFragmentViewModel) {
        notesAdapter.setOnNoteClickListener(new NotesAdapter.OnNoteClickListener() {
            @Override
            public void onNoteClick(Note note) {
                taskFragmentViewModel.showCount();
            }
        });
        recyclerViewNotes.setAdapter(notesAdapter);
        taskFragmentViewModel.getNotes().observe(getViewLifecycleOwner(), new Observer<List<Note>>() {
            @Override
            public void onChanged(List<Note> notes) {
                notesAdapter.setNotes(notes);
            }
        });




    }

    public void onResume(TaskFragmentViewModel taskFragmentViewModel) {
        super.onResume();
        taskFragmentViewModel.refreshList();
    }
}