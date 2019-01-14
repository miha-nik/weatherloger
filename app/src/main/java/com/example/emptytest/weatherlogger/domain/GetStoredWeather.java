package com.example.emptytest.weatherlogger.domain;

import com.example.emptytest.weatherlogger.data.model.StoredWeather;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

@Singleton
public class GetStoredWeather {

    WeatherRepository repository;

    @Inject
    GetStoredWeather(WeatherRepository repository){
        this.repository = repository;
    }

    public Observable<List<StoredWeather>> getStoredWeather(){
        return repository.weathers();
    }
}
