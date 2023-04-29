package com.example.levelapp0005v1.TaskLog;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.schedulers.Schedulers;

import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;

public class AddTaskViewModel extends AndroidViewModel {
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private TasksDao tasksDao;
    private MutableLiveData<Boolean> sholdCloseScreen = new MutableLiveData<>();

    public AddTaskViewModel(@NonNull Application application) {
        super(application);
        tasksDao = TaskDatabase.getInstance(application).tasksDao();
    }

    public LiveData<Boolean> getShouldCloseScreen(){
        return sholdCloseScreen;
    }

    public void saveTask(Task task) {
        Disposable disposable = addTaskRx(task)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action() {
                    @Override
                    public void run() throws Throwable {
                        Log.d("AddTaskViewModel", "subscribe");
                        sholdCloseScreen.postValue(true);
                    }
                });
    }

    public Completable addTaskRx(Task task) {
        return Completable.fromAction(new Action() {
            @Override
            public void run() throws Throwable {
                tasksDao.add(task);
            }
        });
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.dispose();
    }
}
