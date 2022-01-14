package com.example.sunnyweather;

import android.app.Application;
import android.content.Context;

public class SunnyWeatherApplication extends Application {

    private static Context context;

    private static final String TOKEN = "vyvEMWldClHfteGM";

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }

    public static String getTOKEN() {
        return TOKEN;
    }
}
