package com.example.emptytest.weatherlogger.utils;

import android.content.Context;
import android.net.ConnectivityManager;

public class Utils
  {
    public static boolean isInternetConnected(Context context)
    {
      ConnectivityManager connectivityManager=(ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);

      return
              connectivityManager!=null&&
                      (
                              connectivityManager.getNetworkInfo(0)!=null&&
                                      (
                                              connectivityManager.getNetworkInfo(0).getState()==android.net.NetworkInfo.State.CONNECTED||
                                                      connectivityManager.getNetworkInfo(0).getState()==android.net.NetworkInfo.State.CONNECTING
                                      )||
                                      connectivityManager.getNetworkInfo(1)!=null&&
                                              (
                                                      connectivityManager.getNetworkInfo(1).getState()==android.net.NetworkInfo.State.CONNECTING||
                                                              connectivityManager.getNetworkInfo(1).getState()==android.net.NetworkInfo.State.CONNECTED
                                              )
                      );
    }

  }
