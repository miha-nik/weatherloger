package com.example.emptytest.weatherlogger.presentation;

import com.example.emptytest.weatherlogger.data.model.StoredWeather;

import java.util.List;

public interface WeatherActivityPresenter {

    interface View{
        public void showLoading();
        public void hideLoading();
        public void updateWeather(List<StoredWeather> weathers);
    }

    interface Presenter{
        public void save();
        public void attachView(WeatherActivityPresenter.View view);
        void detachView();
    }



}
