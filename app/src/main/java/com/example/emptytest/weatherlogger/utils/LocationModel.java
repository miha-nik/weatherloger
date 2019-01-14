package com.example.emptytest.weatherlogger.utils;

import com.google.gson.annotations.Expose;

/**
 * Created by user on 16.11.15.
 */
public class LocationModel {
    @Expose
    private String status;
    @Expose
    private String country;
    @Expose
    private String city;
    @Expose
    private String query;

    public LocationModel(String status, String country, String city, String query) {
        this.status = status;
        this.country = country;
        this.city = city;
        this.query = query;
    }

    public LocationModel(){

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}
