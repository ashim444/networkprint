package com.example.ashimghimire.network.model;

import com.example.ashimghimire.network.local.LaunchDatabase;
import com.google.gson.annotations.SerializedName;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

@Table(database = LaunchDatabase.class)
public class LaunchImages extends BaseModel {

    @Column
    @PrimaryKey
    int id;

    @Column
    @SerializedName("mission_patch_small")
    String lunchesSmallImageUrl;

    @Column
    @SerializedName("mission_patch")
    String lunchesBigImageUrl;

    public String getLunchesSmallImageUrl() {
        return lunchesSmallImageUrl;
    }

    public String getLunchesBigImageUrl() {
        return lunchesBigImageUrl;
    }
}
