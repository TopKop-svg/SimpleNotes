package com.example.levelapp0005v1.ui.notifications;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.levelapp0005v1.R;
import com.example.levelapp0005v1.TaskLog.Task;

import java.util.List;

public class NotifyAdapter extends RecyclerView.Adapter<NotifyViewHolder> {
    private List<Task> mTask;

    public NotifyAdapter(List<Task> data) {
        mTask = data;
    }

    public NotifyAdapter() {

    }

    @NonNull
    @Override
    public NotifyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_notifications, parent, false);
        return new NotifyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotifyViewHolder holder, int position) {
        Task data = mTask.get(position);
        holder.bind(data);
    }

    @Override
    public int getItemCount() {
        return mTask.size();
    }
}
