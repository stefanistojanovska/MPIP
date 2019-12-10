package com.wp.viewmodels;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.wp.asynctask.MoviesAsyncTask;
import com.wp.db.Repository;
import com.wp.models.Movie;

import java.util.List;

public class MovieViewModel extends AndroidViewModel {

    Repository repository;

    public MovieViewModel(Application application) {
        super(application);
        repository = new Repository(application);
        fetchData();
    }

    public LiveData<List<Movie>> getAll() {
        return repository.getAllMovies();
    }

    private void fetchData() {
        MoviesAsyncTask asyncTask = new MoviesAsyncTask(repository);
        asyncTask.execute(1867419722L);
    }

}
