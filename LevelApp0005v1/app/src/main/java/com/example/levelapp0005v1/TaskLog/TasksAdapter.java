package com.example.levelapp0005v1.TaskLog;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.levelapp0005v1.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class TasksAdapter extends RecyclerView.Adapter<TasksAdapter.TaskViewHolder> {

    private List<Task> tasks = new ArrayList<>();
    private OnTaskClickListener onTaskClickListener;

    public void setOnTaskClickListener(OnTaskClickListener onTaskClickListener) {
        this.onTaskClickListener = onTaskClickListener;
    }

    public List<Task> getTasks() {
        return new ArrayList<>(tasks);
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TasksAdapter.TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.activity_task_item,
                parent,
                false
        );
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TasksAdapter.TaskViewHolder holder, int position) {
        Task task = tasks.get(position);

    }

    @Override
    public int getItemCount() {
        return 0;
    }


    class TaskViewHolder extends RecyclerView.ViewHolder {
    private TextView textViewTask;
        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTask = itemView.findViewById(R.id.textViewNote);
        }
    }

    interface OnTaskClickListener {
        void onNoteClick(Task task);
    }
}
