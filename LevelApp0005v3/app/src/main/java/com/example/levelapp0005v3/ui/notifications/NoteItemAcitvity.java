package com.example.levelapp0005v3.ui.notifications;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.levelapp0005v3.R;

public class NoteItemAcitvity extends AppCompatActivity {
    private ImageView imageView;
    private ViewModel viewModel;

    private boolean playOrStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note_item);
        initViews();
       /*imageView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if (playOrStop) {
                    Log.d("false type", "stop player");
                   imageView.setImageResource(R.drawable.stop_icon_152523);
                   System.out.println("ture");
               } else {
                   Log.d("true type", "play player");
                   imageView.setImageResource(R.drawable.play_icon_152559);
                   System.out.println("false");
               }
               playOrStop = !playOrStop;
           }
       });*/
    }

    private void initViews() {
        viewModel = new ViewModelProvider(this).get(NotificationsViewModel.class);
        imageView = findViewById(R.id.imageViewPlay);
        playOrStop = false;
    }
}