package com.example.levelapp0006v3.WorkWithNotes;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class TaskFragmentViewModel extends AndroidViewModel {
    private NoteDataBase noteDatabase;
    private int count = 0;
    private MutableLiveData<Integer> countLD = new MutableLiveData<>();
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private MutableLiveData<List<Note>> notes = new MutableLiveData<>();

    public TaskFragmentViewModel(@NonNull Application application) {
        super(application);
        noteDatabase = NoteDataBase.getInstance(application);

    }

    public LiveData<List<Note>> getNotes() {

        return notes;
    }

    public void refreshList() {
        Disposable disposable = noteDatabase.notesDao().getNotes()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Note>>() {
                    @Override
                    public void accept(List<Note> notesFromDB) throws Throwable {
                        notes.setValue(notesFromDB);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Throwable {
                        throw new RuntimeException("MainViewModel");
                    }
                });
        compositeDisposable.add(disposable);
    }

    public LiveData<Integer> getCount() {
        return countLD;
    }

    public void showCount() {
        count++;
        countLD.setValue(count);
    }

    public void remove(Note note) {
        Disposable disposable = noteDatabase.notesDao().remove(note.getId())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action() {
                    @Override
                    public void run() throws Throwable {
                        Log.d("MainViewModel", "complete");
                        refreshList();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Throwable {
                        throw new RuntimeException("MainViewModel method remove is not working");
                    }
                });
        compositeDisposable.add(disposable);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.dispose();
    }
}
