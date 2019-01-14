package com.example.emptytest.weatherlogger.domain;

import io.reactivex.Observable;
import com.example.emptytest.weatherlogger.data.model.StoredWeather;

import java.util.List;

public interface WeatherRepository {

    Observable<List<StoredWeather>> weathers();
}
