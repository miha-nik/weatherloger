package com.example.emptytest.weatherlogger.data.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import com.example.emptytest.weatherlogger.data.model.StoredWeather;

import java.util.List;

@Dao
public interface StoredWeatherDao
  {
    @Query("SELECT * FROM storedweather") public List<StoredWeather> getWeathers();
    @Insert
    public void addWeather(StoredWeather weather);
  }
