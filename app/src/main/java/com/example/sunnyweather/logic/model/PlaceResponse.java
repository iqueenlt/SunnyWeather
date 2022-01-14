package com.example.sunnyweather.logic.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PlaceResponse {

    private String status;

    private List<Place> places;

    public class Place {

        private String name;

        private Location location;

        @SerializedName("formatted_address")
        private String address;

        private class Location {

            private String lng;

            private String lat;
        }

        public String getName() {
            return name;
        }

        public String getAddress() {
            return address;
        }
    }

    public List<Place> getPlaces() {
        return places;
    }
}
