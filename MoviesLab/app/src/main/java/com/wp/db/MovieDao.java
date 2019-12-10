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
    //@Query("SELECT * from moviesDb WHERE custom_title LIKE :title")
    //public List<DzTrack> findByTitle(String title); // title == "abc"

   // @Query("SELECT * from dz_track WHERE id = :id")
   // public DzTrack findById(Long id);

    @Insert
    public void insert(Movie ...movies);

   // @Query("DELETE from dz_track WHERE id = :id")
    //public void delete(Long id);

    @Query("DELETE from moviesDb")
    public void deleteAll();



}