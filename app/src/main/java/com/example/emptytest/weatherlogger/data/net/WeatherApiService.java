package com.example.emptytest.weatherlogger.data.net;

import com.example.emptytest.weatherlogger.data.model.CityWeather;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApiService {

    @GET("data/2.5/weather?")
    Observable<CityWeather> getWeather(@Query("q") String cityName,@Query("units") String units, @Query("appid") String appid);
}
