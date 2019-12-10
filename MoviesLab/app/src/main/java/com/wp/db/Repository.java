package com.wp.db;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import androidx.lifecycle.LiveData;
import androidx.room.Room;
import com.wp.models.Movie;

import java.util.List;

public class Repository {

    private static MoviesDatabase database = null;

    public Repository(Context context) {
        if(database == null) {
            database = Room
                    .databaseBuilder(context, MoviesDatabase.class, "db-app")
                    .build();
        }
    }

    public LiveData<List<Movie>> getAllMovies() {
        return database.getMovieDao().getAllAsync();
    }

    @SuppressLint("StaticFieldLeak")
    public void insert(Movie movie) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                database.getMovieDao().insert(movie);
                return null;
            }
        }.execute();
    }
    @SuppressLint("StaticFieldLeak")
    public void deleteAll() {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                database.getMovieDao().deleteAll();
                return null;
            }
        }.execute();


    }
    }
