package com.example.emptytest.weatherlogger.data.db;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DBServiceModule {

    @Provides
    @Singleton
    public DBManager provideDBManager(@NonNull Context context)
    {
        return Room.databaseBuilder(context.getApplicationContext(),DBManager.class,"weather_db").build();
    }
}
