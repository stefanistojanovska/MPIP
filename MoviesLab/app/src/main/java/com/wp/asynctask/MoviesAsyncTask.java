package com.wp.asynctask;

import android.os.AsyncTask;
import com.wp.clients.OmdbApiClient;
import com.wp.db.Repository;
import com.wp.models.Movie;
import com.wp.models.MovieList;
import retrofit2.Call;

import java.io.IOException;

public class MoviesAsyncTask extends AsyncTask<Long, Integer, MovieList> {
    Repository repository;

    public MoviesAsyncTask(Repository repository){
        this.repository = repository;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        repository.deleteAll();
    }

    @Override
    protected MovieList doInBackground(Long... longs) {
        final Call<MovieList> movieList = OmdbApiClient.getService().getMovieList(" ","3db28c7f");
                //MoviesService.getMovieList(" ","3db28c7f");
        try {

            return movieList.execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(MovieList movieList) {
        for(Movie m: movieList.movies) {
            repository.insert(m);
        }

    }
}
