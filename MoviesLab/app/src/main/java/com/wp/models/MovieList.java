package com.wp.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieList {
    @SerializedName("Search")
    public List<Movie> movies;

    public List<Movie> getData() {
        return movies;
    }
}
