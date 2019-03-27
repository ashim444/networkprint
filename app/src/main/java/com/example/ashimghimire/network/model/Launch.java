package com.example.ashimghimire.network.model;

import com.google.gson.annotations.SerializedName;

public class Launch {

    @SerializedName("flight_number")
    private int lunchesFlightNumber;

    @SerializedName("mission_name")
    private String lunchesMissionName;

    @SerializedName("links")
    private LaunchImages launchImages;

    public LaunchImages getLaunchImages() {
        return launchImages;
    }

    public int getLunchesFlightNumber() {
        return lunchesFlightNumber;
    }

    public String getLunchesMissionName() {
        return lunchesMissionName;
    }
}
