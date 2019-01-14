package com.example.emptytest.weatherlogger.data.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName="storedweather")
public class StoredWeather {

    public StoredWeather(){}

    @Ignore
    public StoredWeather(String city, double temp, long date, String icon) {
        this.city = city;
        this.temp = temp;
        this.date = date;
        this.icon = icon;
    }

    @PrimaryKey(autoGenerate=true) public long id;
    @ColumnInfo(name="city")public String city;
    @ColumnInfo(name="temp")public double temp;
    @ColumnInfo(name="date")public long date;
    @ColumnInfo(name="icon")public String icon;
}
