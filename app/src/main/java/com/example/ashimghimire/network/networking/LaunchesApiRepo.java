package com.example.ashimghimire.network.networking;

public class LaunchesApiRepo {
    private static final LaunchesApiRepo ourInstance = new LaunchesApiRepo();

    public static LaunchesApiRepo getInstance() {
        return ourInstance;
    }

    private LaunchesApiRepo() {
        if(ourInstance == null){

        }

    }
}
