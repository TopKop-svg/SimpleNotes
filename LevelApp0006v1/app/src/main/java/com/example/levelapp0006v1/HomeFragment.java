package com.example.levelapp0006v1;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.levelapp0006v1.databinding.FragmentHomeBinding;


public class HomeFragment extends Fragment {
    private int count = 0;
    private Button button;
    private ProgressBar progressBar;
    private ProgressBar progressBarSecond;
    private SeekBar seekBar;
    private TextView textView;
    private FragmentHomeBinding binding;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        // Inflate the layout for this fragment
        initViews(root);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count+=10;
                Log.d("HomeFragment", "Count Size: " + count);
                textView.setText("count");
            }
        });
        textView.setText("Finnish");
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (progress >= 100) {
                    progressBar.setVisibility(View.INVISIBLE);
                    progressBarSecond.setVisibility(View.VISIBLE);
                } else {
                    progressBar.setVisibility(View.VISIBLE);
                    progressBarSecond.setVisibility(View.INVISIBLE);
                }
                textView.setText(String.valueOf(progress) + "%");
                progressBar.setProgress(progress);
                progressBarSecond.setProgress(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                seekBar.setProgress(10);
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        return root;
    }

    private void initViews(View view) {
        progressBar = view.findViewById(R.id.progressBar);
        progressBarSecond = view.findViewById(R.id.progressBarSecond);
        seekBar = view.findViewById(R.id.seekBar);
        textView = view.findViewById(R.id.textViewWithSeekBar);
        button = view.findViewById(R.id.button);
    }

    public void onClickHistory(View view) {
        HistoryFragment historyFragment = new HistoryFragment();


    }
}