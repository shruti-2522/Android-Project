package com.example.customised_city_traveler;

import retrofit.RestAdapter;

public class Config {
    public static final String ROOT_URL =  "http://192.168.43.242/City_Traveler1/";
    public static String uid = "";
    public RegisterAPI api;

    public void abc() {
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint(Config.ROOT_URL) //Setting the Root URL
                .build(); //Finally building the adapter
        api = adapter.create(RegisterAPI.class);
    }

}