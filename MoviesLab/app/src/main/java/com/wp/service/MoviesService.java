package com.wp.service;

import com.wp.models.Movie;
import com.wp.models.MovieList;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MoviesService {
    @GET("/")
    Call<Movie> getMovie( @Query("i") String id,@Query("apikey") String apiKey);

    @GET("/")
    Call<MovieList> getMovieList( @Query("s") String queryString,@Query("apikey") String apiKey);

}
