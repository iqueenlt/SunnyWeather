package com.example.sunnyweather.logic;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.sunnyweather.logic.model.PlaceResponse;
import com.example.sunnyweather.logic.network.RequestCallback;
import com.example.sunnyweather.logic.network.SunnyWeatherNetwork;

public class Repository {

    private MutableLiveData<PlaceResponse> placeResponseLiveData = new MutableLiveData<>();

    public LiveData<PlaceResponse> searchPlaces(String query) {
        new SunnyWeatherNetwork().searchPlaces(query, new RequestCallback<PlaceResponse>() {
            @Override
            public void onSuccess(PlaceResponse data) {
                placeResponseLiveData.postValue(data);
            }

            @Override
            public void onFailure(String errorMsg) {
                placeResponseLiveData.postValue(null);
            }
        });
        return placeResponseLiveData;
    }
}
