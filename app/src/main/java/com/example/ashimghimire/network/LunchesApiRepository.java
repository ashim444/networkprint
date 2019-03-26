package com.example.ashimghimire.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LunchesApiRepository {

    private static LunchesApi lunchesApi;

    public static LunchesApi getLunchesApi() {
        if (lunchesApi == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.spacexdata.com/v3/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            lunchesApi = retrofit.create(LunchesApi.class);
        }
        return lunchesApi;
    }
}
