package com.example.emptytest.weatherlogger.presentation;

import com.example.emptytest.weatherlogger.data.GetWeatherRepository;
import com.example.emptytest.weatherlogger.data.location.LocationData;
import com.example.emptytest.weatherlogger.data.location.NetLocationTracker;
import com.example.emptytest.weatherlogger.data.net.LocationApiService;
import com.example.emptytest.weatherlogger.domain.GetStoredWeather;
import com.example.emptytest.weatherlogger.domain.WeatherRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class WeatherActivityModul {

    @Provides
    LocationData provideLocationData(LocationApiService locationApiService){return new NetLocationTracker(locationApiService); }

    @Provides
    WeatherActivityPresenter.Presenter provideWeatherActivityPresenter(GetStoredWeather getStoredWeather){return new WeatherPresenter(getStoredWeather);}

    @Provides
    @Singleton
    public WeatherRepository provideWetherRepository(GetWeatherRepository repository){ return repository; }
}
