package com.example.ashimghimire.network;

import com.example.ashimghimire.network.model.Launch;

import java.util.List;
public class Repository {
    private List<Launch> repositoryLaunchList;
    //TODO: CREATING DATABASE AND CALLING OBJECT IN DATABASE FIRST AND DISPLAYING IT

//    public Repository() {
//        Call<List<Launch>> lunches = LaunchApiRepository.getLaunchApi().getLunches();
//        lunches.enqueue(new Callback<List<Launch>>() {
//            @Override
//            public void onResponse(Call<List<Launch>> call, Response<List<Launch>> response) {
//                if (!response.isSuccessful()) {
//                    return;
//                }
//                setRepositoryLunchesList(response.body());
//            }
//            @Override
//            public void onFailure(Call<List<Launch>> call, Throwable t) {
//
//            }
//        });
//    }
//
//    public void setRepositoryLunchesList(List<Launch> repositoryLaunchList) {
//        this.repositoryLaunchList = repositoryLaunchList;
//    }
//
//    public List<Launch> getRepositoryLunchesList() {
//        return repositoryLaunchList;
//    }
}
