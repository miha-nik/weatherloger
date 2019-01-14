package com.example.emptytest.weatherlogger;

import com.example.emptytest.weatherlogger.data.db.DBServiceModule;
import com.example.emptytest.weatherlogger.presentation.WeatherActivity;
import com.example.emptytest.weatherlogger.presentation.WeatherActivityModul;
import com.example.emptytest.weatherlogger.data.net.ApiServiceModul;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = { ApplicationModule.class, WeatherActivityModul.class, ApiServiceModul.class, DBServiceModule.class})
public interface ApplicationComponent {

    void inject(WeatherActivity target);
}
