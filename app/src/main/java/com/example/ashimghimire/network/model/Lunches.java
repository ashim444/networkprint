package com.example.ashimghimire.network.model;

import com.google.gson.annotations.SerializedName;

public class Lunches {

    @SerializedName("flight_number")
    private int lunchesFlightNumber;

    @SerializedName("mission_name")
    private String lunchesMissionName;

    @SerializedName("links")
    private LunchesImages lunchesImages;

    public LunchesImages getLunchesImages() {
        return lunchesImages;
    }

    public int getLunchesFlightNumber() {
        return lunchesFlightNumber;
    }

    public String getLunchesMissionName() {
        return lunchesMissionName;
    }

}
