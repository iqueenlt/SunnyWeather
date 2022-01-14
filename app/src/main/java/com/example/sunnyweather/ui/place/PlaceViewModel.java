package com.example.sunnyweather.ui.place;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.example.sunnyweather.logic.Repository;
import com.example.sunnyweather.logic.model.PlaceResponse;

import java.util.ArrayList;
import java.util.List;

public class PlaceViewModel extends ViewModel {

    private MutableLiveData<String> searchLiveData = new MutableLiveData<>();

    public List<PlaceResponse.Place> placeList = new ArrayList<>();

    public LiveData<PlaceResponse> placeLiveData = Transformations.switchMap(searchLiveData, new Function<String, LiveData<PlaceResponse>>() {
        @Override
        public LiveData<PlaceResponse> apply(String input) {
            return new Repository().searchPlaces(input);
        }
    });

    public void searchPlaces(String query) {
        searchLiveData.setValue(query);
    }
}
