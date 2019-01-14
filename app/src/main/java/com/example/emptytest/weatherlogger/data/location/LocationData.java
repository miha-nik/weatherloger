package com.example.emptytest.weatherlogger.data.location;

import com.example.emptytest.weatherlogger.utils.LocationModel;

import io.reactivex.Observable;

public interface LocationData {
    Observable<LocationModel> getLocation();
}
