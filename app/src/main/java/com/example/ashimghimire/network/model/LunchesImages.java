package com.example.ashimghimire.network.model;

import com.google.gson.annotations.SerializedName;

public class LunchesImages {

    @SerializedName("mission_patch_small")
    private String lunchSmallImageUrl;

    @SerializedName("mission_patch")
    private  String lunchBigImageUrl;

    public String getLunchSmallImageUrl() {
        return lunchSmallImageUrl;
    }

    public String getLunchBigImageUrl() {
        return lunchBigImageUrl;
    }
}
