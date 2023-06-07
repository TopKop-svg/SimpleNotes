package com.example.levelapp0007v1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {
    Button buttonFragmentHistory, buttonFragmentCurrent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        buttonFragmentHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickHistory();
            }
        });

        buttonFragmentCurrent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickCurrent();
            }
        });



    }

    private void initViews() {
        buttonFragmentHistory = findViewById(R.id.buttonFragmentHistory);
        buttonFragmentCurrent = findViewById(R.id.buttonFragmentCurrent);

    }

    public void onClickCurrent() {
        CurrentTaskFragment currentTaskFragment = new CurrentTaskFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.cont, currentTaskFragment);
        ft.commit();
    }

    private void onClickHistory() {
        HistoryFragment historyFragment = new HistoryFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.cont, historyFragment);
        ft.commit();

    }

}