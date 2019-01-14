package com.example.emptytest.weatherlogger.presentation;

import android.support.test.espresso.idling.CountingIdlingResource;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.example.emptytest.weatherlogger.R;
import com.example.emptytest.weatherlogger.WeatherApp;
import com.example.emptytest.weatherlogger.data.model.StoredWeather;
import com.example.emptytest.weatherlogger.presentation.adapter.WeatherAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WeatherActivity extends AppCompatActivity implements WeatherActivityPresenter.View {

    private static final int REQUEST_PERMISSION_LOCATION=5;
    public CountingIdlingResource countingIdlingResource=null;

    @Inject
    WeatherActivityPresenter.Presenter presenter;

    @BindView(R.id.weatherList)
    RecyclerView weatherList;

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    WeatherAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        ((WeatherApp)getApplication()).getComponent().inject(this);

        weatherList.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
        weatherList.setItemAnimator(new DefaultItemAnimator());
        mAdapter = new WeatherAdapter(this);
        weatherList.setAdapter(mAdapter);

        countingIdlingResource=new CountingIdlingResource("Data loading");
        presenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void updateWeather(List<StoredWeather> weathers) {
        countingIdlingResource.decrement();
        mAdapter.setItems(weathers);
    }

    @Override public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override public boolean onOptionsItemSelected(MenuItem item)
    {
        switch(item.getItemId())
        {
            case R.id.action_save:
                presenter.save();
                countingIdlingResource.increment();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
