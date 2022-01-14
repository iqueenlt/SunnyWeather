package com.example.sunnyweather.logic.network;

import com.example.sunnyweather.logic.model.PlaceResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SunnyWeatherNetwork {

    private PlaceService placeService = ServiceCreator.getInstance().create(PlaceService.class);

    public void searchPlaces(String query, RequestCallback<PlaceResponse> callback) {
        placeService.searchPlaces(query).enqueue(new Callback<PlaceResponse>() {
            @Override
            public void onResponse(Call<PlaceResponse> call, Response<PlaceResponse> response) {
                PlaceResponse body = response.body();
                if (body != null) {
                    callback.onSuccess(body);
                } else {
                    callback.onFailure("response body is null");
                }
            }

            @Override
            public void onFailure(Call<PlaceResponse> call, Throwable t) {
                callback.onFailure(t.toString());
            }
        });
    }
}
