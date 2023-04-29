package com.example.levelapp0004v1.FinishTasks;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class DeleteNoteViewModel extends AndroidViewModel {
    private DeletedNotesDao deletedNotesDao;
    private MutableLiveData<Boolean> sholdCloseScreen = new MutableLiveData<>();

    public DeleteNoteViewModel(@NonNull Application application) {
        super(application);

    }


}
