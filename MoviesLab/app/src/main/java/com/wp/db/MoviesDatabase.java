package com.wp.db;
import androidx.room.Database;
import androidx.room.RoomDatabase;
import com.wp.models.Movie;

@Database(entities = {Movie.class}, version = 1,exportSchema = false)
public abstract class MoviesDatabase extends RoomDatabase {
    public abstract MovieDao getMovieDao();
    //public abstract void deleteAll();
}
