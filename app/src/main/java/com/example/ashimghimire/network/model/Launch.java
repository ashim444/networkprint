package com.example.ashimghimire.network.model;

import com.example.ashimghimire.network.local.LaunchDatabase;
import com.google.gson.annotations.SerializedName;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ForeignKey;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;


@Table(database = LaunchDatabase.class)
public class Launch extends BaseModel {

    @PrimaryKey(autoincrement = true)
    @Column
    int id;

    public int getId() {
        return id;
    }

    @Column
    @SerializedName("flight_number")
    int lunchesFlightNumber;

    @Column
    @SerializedName("mission_name")
    String lunchesMissionName;


    @Column
    @ForeignKey(saveForeignKeyModel = true)
    @SerializedName("links")
    LaunchImages launchImages;

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
