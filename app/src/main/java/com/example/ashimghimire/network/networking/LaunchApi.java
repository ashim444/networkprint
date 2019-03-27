package com.example.ashimghimire.network.networking;

import com.example.ashimghimire.network.model.Launch;
import com.example.ashimghimire.network.model.LaunchOne;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface LaunchApi {
    @GET(Config.EndpointLaunches.LAUNCHES)
    Call<List<Launch>> getLunches();

    @GET(Config.EndpointLaunches.LAUNCHES+"/{flight_number}")
    Call<Launch> getOneLaunch(@Path("flight_number") int flightNumber);
}
