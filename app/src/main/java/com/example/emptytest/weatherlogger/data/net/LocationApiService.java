package com.example.emptytest.weatherlogger.data.net;

import com.example.emptytest.weatherlogger.utils.LocationModel;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface LocationApiService {
    @GET("json")
    Observable<LocationModel>  getLocation();
}
