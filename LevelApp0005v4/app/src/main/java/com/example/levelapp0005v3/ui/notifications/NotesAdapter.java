package com.example.levelapp0005v3.ui.notifications;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.levelapp0005v3.R;

import java.util.ArrayList;
import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesViewHolder> {
    private List<Note> notes = new ArrayList<>();

    @NonNull
    @Override
    public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull NotesViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    static class NotesViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageViewPoster;
        private TextView textViewRating;


        public NotesViewHolder(@NonNull View itemView) {
            super(itemView);
           /* imageViewPoster = itemView.findViewById(R.id.imageViewPoster);
            textViewRating = itemView.findViewById(R.id.textViewRating);*/
        }
    }
}
