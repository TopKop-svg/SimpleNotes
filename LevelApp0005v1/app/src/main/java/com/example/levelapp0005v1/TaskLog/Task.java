package com.example.levelapp0005v1.TaskLog;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "tasks")
public class Task {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String nameOfTask;

    private double time;

    private boolean noTimeTask;

    int goldOfTask;
    int expOfTask;
    double multiplerReward;

    public Task(int id, String nameOfTask, double time, boolean noTimeTask, int goldOfTask, int expOfTask, double multiplerReward) {
        this.id = id;
        this.nameOfTask = nameOfTask;
        this.time = time;
        this.noTimeTask = noTimeTask;
        this.goldOfTask = goldOfTask;
        this.expOfTask = expOfTask;
        this.multiplerReward = multiplerReward;
    }

    @Ignore
    public Task(String nameOfTask) {
        this.nameOfTask = nameOfTask;
    }

    public void setNameOfTask(String nameOfTask) {
        this.nameOfTask = nameOfTask;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public void setGoldOfTask(int goldOfTask) {
        this.goldOfTask = goldOfTask;
    }

    public void setExpOfTask(int expOfTask) {
        this.expOfTask = expOfTask;
    }

    public void setMultiplerReward(double multiplerReward) {
        this.multiplerReward = multiplerReward;
    }

    public int getId() {
        return id;
    }

    public String getNameOfTask() {
        return nameOfTask;
    }

    public double getTime() {
        return time;
    }

    public boolean isNoTimeTask() {
        return noTimeTask;
    }

    public int getGoldOfTask() {
        return goldOfTask;
    }

    public int getExpOfTask() {
        return expOfTask;
    }

    public double getMultiplerReward() {
        return multiplerReward;
    }
}
