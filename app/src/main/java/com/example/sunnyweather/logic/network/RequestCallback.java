package com.example.sunnyweather.logic.network;

public interface RequestCallback<T extends Object> {

    void onSuccess(T data);

    void onFailure(String errorMsg);
}
