package com.example.emptytest.weatherlogger.data.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.emptytest.weatherlogger.data.model.StoredWeather;

@Database
  (
    entities=
      {
        StoredWeather.class
      },
    version=1
  )
public abstract class DBManager extends RoomDatabase
  {
    public abstract StoredWeatherDao storedWeatherDao();
  }
