package com.example.emptytest.weatherlogger.presentation.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.emptytest.weatherlogger.R;
import com.example.emptytest.weatherlogger.data.model.StoredWeather;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder> {

    private Context mContext;
    private List<StoredWeather> weathers;

    public WeatherAdapter(Context context)
    {
        this.mContext = context;
        weathers = new ArrayList<StoredWeather>();
    }

    @NonNull
    @Override
    public WeatherViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View  view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.weather_item, viewGroup,false);
        return new WeatherViewHolder(mContext, view);
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherViewHolder weatherViewHolder, int i) {

        StoredWeather weather = this.weathers.get(i);
        if(weather==null) return;
        weatherViewHolder.tvLocation.setText(weather.city);
        weatherViewHolder.tvTemperature.setText(String.valueOf(weather.temp));
        String timeLog=SimpleDateFormat.getDateTimeInstance().format(weather.date);
        weatherViewHolder.tvData.setText(timeLog);

        Picasso.get().load(Uri.parse("http://openweathermap.org/img/w/"+weather.icon+".png")).into(weatherViewHolder.ivWeatherIcon);
    }

    @Override
    public int getItemCount() {
        return weathers.size();
    }

    //Only for test
    public void setItems(List<StoredWeather> weathers){
        this.weathers = weathers;
        notifyDataSetChanged();
    }

    public static class WeatherViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        @BindView(R.id.tvLocation)
        TextView tvLocation;
        @BindView(R.id.tvTemperature)
        TextView tvTemperature;
        @BindView(R.id.tvData)
        TextView tvData;
        @BindView(R.id.ivWeatherIcon)
        ImageView ivWeatherIcon;

        @BindView(R.id.weatherItem)
        ConstraintLayout weatherItem;

        public WeatherViewHolder(Context context, View itemView)
        {
            super(itemView);

            ButterKnife.bind(this, itemView);
            if(weatherItem!=null){
                weatherItem.setOnClickListener(this);
            }
        }

        @Override
        public void onClick(View view) {

        }
    }
}
