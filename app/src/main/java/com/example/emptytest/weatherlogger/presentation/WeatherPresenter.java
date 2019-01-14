package com.example.emptytest.weatherlogger.presentation;

import com.example.emptytest.weatherlogger.domain.GetStoredWeather;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;;

public class WeatherPresenter implements WeatherActivityPresenter.Presenter {

    private WeatherActivityPresenter.View view;
    private GetStoredWeather storedWeather;
    private CompositeDisposable disposable;

    private Scheduler observerThread;

    public WeatherPresenter(GetStoredWeather storedWeather){
        this.storedWeather = storedWeather;
        disposable = new CompositeDisposable();
        this.observerThread = AndroidSchedulers.mainThread();
    }
    public WeatherPresenter(GetStoredWeather storedWeather, Scheduler observerThread){
        this.storedWeather = storedWeather;
        disposable = new CompositeDisposable();
        this.observerThread = observerThread;
    }

    @Override
    public void attachView(WeatherActivityPresenter.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
        clear();
    }

    private void clear(){
        disposable.clear();
    }

    @Override
    public void save() {
        if (view != null) {
            view.showLoading();
        }
        disposable.add(storedWeather.getStoredWeather()
                .subscribeOn(Schedulers.io())
                .observeOn(observerThread)
                .doOnTerminate(() -> {
                    if (view != null) {
                        view.hideLoading();
                    }
                })
                .subscribe(weathers ->{
                            if(weathers!=null && view!=null){
                                view.updateWeather(weathers);
                            }
                        },
                        error ->{
                            clear();
                        }
                ));
    }

}
