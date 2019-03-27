package com.example.ashimghimire.network.model;

import com.google.gson.annotations.SerializedName;

public class LaunchImages {

    @SerializedName("mission_patch_small")
    private String lunchesSmallImageUrl;

    @SerializedName("mission_patch")
    private String lunchesBigImageUrl;

    public String getLunchesSmallImageUrl() {
        return lunchesSmallImageUrl;
    }

    public String getLunchesBigImageUrl() {
        return lunchesBigImageUrl;
    }
}
