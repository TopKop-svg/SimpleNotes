package com.example.levelapp0005v3.ui.notifications;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.levelapp0005v3.R;
import com.example.levelapp0005v3.databinding.FragmentNotificationsBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class NotificationsFragment extends Fragment {
    private GridLayout constraintLayout;
    private FloatingActionButton floatingActionButton;
    private ImageView imageView;
    private boolean playOrStop;

    private ArrayList<Note> notes = new ArrayList<>();
    private FragmentNotificationsBinding binding;

    @SuppressLint("ResourceType")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        /*NotificationsViewModel notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);*/
        

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        initView(root);

        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            Note note = new Note(i, "Note" + i, random.nextInt(3), R.drawable.play_icon_152559);
            notes.add(note);
        }
        showNotes(root);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void initView(View view) {
        floatingActionButton = view.findViewById(R.id.buttonAddNote);
        constraintLayout = view.findViewById(R.id.gridLayoutNotes);
        playOrStop = false;
    }


    private void showNotes(View root) {

        for (Note note: notes) {
            View view = getLayoutInflater().inflate(
                    R.layout.note_item,
                    constraintLayout,
                    false
            );

            TextView textViewNote = view.findViewById(R.id.textViewRating);
            textViewNote.setText(note.getText());

            int colorResId;
            switch (note.getPriority()) {
                case 0:
                    colorResId = android.R.color.holo_green_light;
                    break;
                case 1:
                    colorResId = android.R.color.holo_orange_light;
                    break;
                default:
                    colorResId = android.R.color.holo_red_light;
            }
            int color = ContextCompat.getColor(requireContext(), colorResId);
            textViewNote.setBackgroundColor(color);

            imageView = view.findViewById(R.id.imageViewPlay);

            boolean clickOnTimer = false;
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    imageView = view.findViewById(R.id.imageViewPlay);
                        imageView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                playOrStop = !playOrStop;
                                Log.d("Tap", "you push the button id " + note.getId());
                                Log.d("Tap", "image note " + note.getImageView());
                                if (playOrStop) {
                                    note.setImageView(R.drawable.stop_icon_152523);
                                    imageView.setImageResource(R.drawable.stop_icon_152523);
                                } else {
                                    note.setImageView(R.drawable.play_icon_152559);
                                    imageView.setImageResource(R.drawable.play_icon_152559);
                                }
                            }
                        });

                        // Создать интент для перехода на Activity NoteActivity
                        Intent intent = new Intent(requireContext(), NoteActivity.class);
                        // Передать ID заметки в интент
                        intent.putExtra("noteId", note.getId());
                        // Запустить Activity
                        startActivity(intent);




                }
            });



            constraintLayout.addView(view);
        }
    }

}