package com.example.simplenotes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NotesAdapter extends RecyclerView.Adapter<> {

    private ArrayList<Note> notes = new ArrayList<>();

    public void setNotes(ArrayList<Note> notes) {
        this.notes = notes;
    }

    @NonNull
    @Override
    public View onCreateView(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_item,
                parent,
                false);
        return view;
    }

    @Override
    public void onBindView(View view, int position) {
        Note note = notes.get(position);
        CheckBox checkBox = view.findViewById(R.id.checkBoxNote);
        checkBox.setText(note.getTitle());
        onClickButtonOption(note, view);
        onClickButtonPlay(note, view);
        TextView textView = view.findViewById(R.id.textViewExplanation);
        textView.setText(note.getText());
        linearLayout.addView(view);

    }

    @Override
    public int getItemCount() {
        return notes.size();
    }
}
