package com.example.levelapp0007v1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.NumberPicker;

public class CurrentTaskFragment extends Fragment {
    NumberPicker numberPickerHour;
    NumberPicker numberPickerMinute;
    Button buttonStart;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = this.getView();
        initViews(view);

        return inflater.inflate(R.layout.fragment_current_task, container, false);
    }

    private void initViews(View view) {
        numberPickerHour = view.findViewById(R.id.numberPickerHour);
        numberPickerMinute = view.findViewById(R.id.numberPickerMinute);
        buttonStart = view.findViewById(R.id.buttonStart);
    }
}