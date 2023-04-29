package com.example.movies;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>{
    private List<Movie> movies = new ArrayList<>();
    private OnReachEndListener onReachEndListener;

    private OnMovieClick onReachMovieDetailActivity;

    public void setOnReachMovieDetailActivity(OnMovieClick onReachMovieDetailActivity) {
        this.onReachMovieDetailActivity = onReachMovieDetailActivity;
    }

    DecimalFormat dF = new DecimalFormat("0.0");

    public void setOnReachEndListener(OnReachEndListener onReachEndListener) {
        this.onReachEndListener = onReachEndListener;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_item,
                        parent,
                        false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        Movie movie = movies.get(position);
        
        Glide.with(holder.itemView)
                .load(movie.getPoster().getUrl())
                .into(holder.imageViewPoster);

        double rating = movie.getRating().getKp();
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onReachMovieDetailActivity != null) {
                    onReachMovieDetailActivity.onReachMovie(movie);
                }
            }
        });
        int backgroundId ;
        if (rating > 7) {
            backgroundId = R.drawable.circle_green;
        } else if (rating > 5) {
            backgroundId = R.drawable.circle_orange;
        } else {
            backgroundId = R.drawable.circle_red;
        }
        Drawable background = ContextCompat.getDrawable(holder.itemView.getContext(), backgroundId);
        holder.textViewRating.setBackground(background);
        holder.textViewRating.setText(dF.format(rating));

        if (position == movies.size() -1 && onReachEndListener != null) {
            onReachEndListener.onReachEnd();
        }
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    interface OnReachEndListener {
        void onReachEnd();
    }

    interface OnMovieClick {
        void onReachMovie(Movie movie);
    }

    static class MovieViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageViewPoster;
        private TextView textViewRating;


        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewPoster = itemView.findViewById(R.id.imageViewPoster);
            textViewRating = itemView.findViewById(R.id.textViewRating);
        }
    }


}
