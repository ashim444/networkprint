package com.example.ashimghimire.network.local;

import android.util.Log;

import com.example.ashimghimire.network.model.Launch;
import com.example.ashimghimire.network.networking.LaunchApiRepository;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DatabaseRepo {
    private static final DatabaseRepo ourInstance = new DatabaseRepo();

    public  List<Launch> getLaunchList() {
        return launchList;
    }

    public   void setLaunchList(List<Launch> launchList) {
        this.launchList = launchList;
    }

    private  List<Launch> launchList;

    public static DatabaseRepo getInstance() {
        if (ourInstance != null) {
            Call<List<Launch>> lunches = LaunchApiRepository.getLaunchApi().getLunches();
            lunches.enqueue(new Callback<List<Launch>>() {
                @Override
                public void onResponse(Call<List<Launch>> call, Response<List<Launch>> response) {
                    if (!response.isSuccessful()) {
                        return;
                    }
                    //TODO get or set response.body()
                    Log.v("asdas", "asdasdasdasd");
                }

                @Override
                public void onFailure(Call<List<Launch>> call, Throwable t) {
                    //TODO couter failer case
                    Log.v("asdas", "asdasdasdasd");
                }
            });

        }
        return ourInstance;
    }


    private DatabaseRepo() {

    }
}
