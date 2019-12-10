package com.wp.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "moviesDb")
public class Movie {
    @PrimaryKey
    public Long Id;
    public String title;
    public int year;
    public String img;
}