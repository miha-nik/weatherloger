package com.example.emptytest.weatherlogger.presentation;

import com.example.emptytest.weatherlogger.data.model.StoredWeather;
import com.example.emptytest.weatherlogger.domain.GetStoredWeather;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class WeatherPresenterTest {

    WeatherPresenter presenter;
    @Mock GetStoredWeather storedWeather;
    @Mock WeatherActivityPresenter.View mokeView;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        presenter = new WeatherPresenter(storedWeather,Schedulers.trampoline());
        presenter.attachView(mokeView);
    }

    @After
    public void tearDown() throws Exception {
        presenter.detachView();
    }

    private List<StoredWeather> getFakeOrderList() {
        List<StoredWeather> weathers = new ArrayList<>();
        weathers.add(new StoredWeather("Landon", 10.0, 1L,"icon"));
        weathers.add(new StoredWeather("Berlin", 10.0, 1L,"icon"));
        return weathers;
    }
    @Test
    public void saveOk() {

        List<StoredWeather> fakeOrders = getFakeOrderList();
        when(storedWeather.getStoredWeather()).thenReturn(Observable.<List<StoredWeather>>just(fakeOrders));

        presenter.save();

        verify(mokeView).showLoading();
        verify(mokeView).hideLoading();
        verify(mokeView).updateWeather(anyList());
    }
}