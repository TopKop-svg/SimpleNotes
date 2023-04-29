package com.example.levelapp0005v1.ui.notifications;

import android.view.View;
import android.widget.ProgressBar;

import androidx.recyclerview.widget.RecyclerView;

import com.example.levelapp0005v1.R;
import com.example.levelapp0005v1.TaskLog.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class NotifyViewHolder extends RecyclerView.ViewHolder {
    private FloatingActionButton floatingActionButton;

    public NotifyViewHolder(View view) {
        super(view);
        floatingActionButton = view.findViewById(R.id.buttonAddNote);
    }

    public void bind(Task task){

    }
}
