package com.example.emptytest.weatherlogger.data;

import com.example.emptytest.weatherlogger.data.db.DBManager;
import com.example.emptytest.weatherlogger.data.location.LocationData;
import com.example.emptytest.weatherlogger.data.model.CityWeather;
import com.example.emptytest.weatherlogger.data.model.StoredWeather;
import com.example.emptytest.weatherlogger.data.net.WeatherApiService;
import com.example.emptytest.weatherlogger.domain.WeatherRepository;

import java.util.Calendar;
import java.util.List;
import javax.inject.Inject;
import io.reactivex.Observable;

public class GetWeatherRepository implements WeatherRepository {

    private static final String API_ID = "fff525e5b304d32b696df3010847ddb2";
    private static final String API_UNITS = "metric";

    private WeatherApiService weatherRequest;
    private LocationData locationData;
    private DBManager dbManager;

    @Inject
    GetWeatherRepository(LocationData locationData, WeatherApiService weatherRequest, DBManager dbManager){
        this.weatherRequest = weatherRequest;
        this.locationData = locationData;
        this.dbManager = dbManager;
    }

    @Override
    public Observable<List<StoredWeather>> weathers() {
        return this.locationData.getLocation()
                .flatMap(location -> weatherRequest.getWeather(location.getCity(),API_UNITS,API_ID))
                .map(cityWeather -> storedWeathers(cityWeather));
    }

    private List<StoredWeather> storedWeathers(CityWeather weather){
        storeWeather(weather);
        return this.dbManager.storedWeatherDao().getWeathers();
    }

    private void storeWeather(CityWeather weather){

        StoredWeather w = new StoredWeather();
        w.city = weather.getName();
        w.temp = weather.getMain().getTemp();
        w.date = Calendar.getInstance().getTimeInMillis();
        w.icon = weather.getWeather().get(0).getIcon();

        this.dbManager.storedWeatherDao().addWeather(w);
    }
}
