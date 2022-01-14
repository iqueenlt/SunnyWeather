package com.example.sunnyweather.logic.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceCreator {

    private static final String BASE_URL = "https://api.caiyunapp.com/";

    private static volatile ServiceCreator INSTANCE;

    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    static ServiceCreator getInstance() {
        if (INSTANCE == null) {
            synchronized (ServiceCreator.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ServiceCreator();
                }
            }
        }
        return INSTANCE;
    }

    public <T> T create(Class<T> serviceClass) {
        return retrofit.create(serviceClass);
    }
}
