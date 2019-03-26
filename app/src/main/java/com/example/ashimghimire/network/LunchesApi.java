package com.example.ashimghimire.network;

import com.example.ashimghimire.network.model.Lunches;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface LunchesApi {
    @GET("launches")
    Call<List<Lunches>> getLunches();
}
