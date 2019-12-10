package com.wp.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import com.wp.models.Movie;

import java.util.List;

@Dao  //METODI ZA OPERACII VO BAZATA
public interface MovieDao {

    @Query("SELECT * from moviesDb")
    public List<Movie> getAll();

    @Query("SELECT * from moviesDb")
    public LiveData<List<Movie>> getAllAsync();


    @Insert
    public void insert(Movie ...movies);



    @Query("DELETE from moviesDb")
    public void deleteAll();



}