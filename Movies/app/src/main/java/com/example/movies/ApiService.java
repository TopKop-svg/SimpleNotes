package com.example.movies;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("movie?token=SPSBWKR-XH649SM-K7ZDEQ1-HTQAT5V&field=rating.kp&search=4-8&sortField=votes.kp&sortType=-1&&limit=30")
    Single<MovieResponse> loadMovies(@Query("page") int page);
}
