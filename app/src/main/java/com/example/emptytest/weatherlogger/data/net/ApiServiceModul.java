package com.example.emptytest.weatherlogger.data.net;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApiServiceModul {

    public final String WEATHER_BASE_URL = "http://api.openweathermap.org/";
    public final String LOCATION_BASE_URL = "http://ip-api.com/";

    @Provides
    public OkHttpClient provideClient() {
        OkHttpClient HTTP_CLIENT = new OkHttpClient();
        return HTTP_CLIENT.newBuilder().connectTimeout(60, TimeUnit.SECONDS).readTimeout(60, TimeUnit.SECONDS).build();
    }

    @Provides
    public Retrofit provideRetrofit(String baseURL, OkHttpClient client) {
        return new Retrofit.Builder()
                .baseUrl(baseURL)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    public WeatherApiService provideWeatherApiService() {
        return provideRetrofit(WEATHER_BASE_URL, provideClient()).create(WeatherApiService.class);
    }

    @Provides
    public LocationApiService provideLoacationApiService() {
        return provideRetrofit(LOCATION_BASE_URL, provideClient()).create(LocationApiService.class);
    }
}
