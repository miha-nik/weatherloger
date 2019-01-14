package com.example.emptytest.weatherlogger.data.location;

import com.example.emptytest.weatherlogger.data.net.LocationApiService;
import com.example.emptytest.weatherlogger.utils.LocationModel;

import io.reactivex.Observable;

public class NetLocationTracker implements LocationData {

    private static final String LOCATION_JSON = "LOCATION_JSON";
    private static final String STATUS_FAIL = "fail";
    public static final String INTENT_TAG = "INTENT_TAG";
    public static final int UPDATE_MY_LOCATION = 1;
    public static final String RECEIVER_TAG = "RECEIVER_TAG";

    public static final int LOCATION_RESULT_CODE = 1;
    public static final String MY_COUNTRY = "MY_COUNTRY";
    public static final String MY_CITY = "MY_CITY";


    LocationApiService locationApiService;

    public NetLocationTracker(LocationApiService locationApiService){
        this.locationApiService = locationApiService;
    }

    @Override
    public Observable<LocationModel> getLocation() {
        return locationApiService.getLocation();
    }
}
