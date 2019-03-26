package com.example.ashimghimire.network;

import com.example.ashimghimire.network.model.Lunches;

import java.util.List;

public class Repository {
    private List<Lunches> repositoryLunchesList;
    //TODO: CREATING DATABASE AND CALLING OBJECT IN DATABASE FIRST AND DISPLAYING IT

//    public Repository() {
//        Call<List<Lunches>> lunches = LunchesApiRepository.getLunchesApi().getLunches();
//        lunches.enqueue(new Callback<List<Lunches>>() {
//            @Override
//            public void onResponse(Call<List<Lunches>> call, Response<List<Lunches>> response) {
//                if (!response.isSuccessful()) {
//                    return;
//                }
//                setRepositoryLunchesList(response.body());
//            }
//            @Override
//            public void onFailure(Call<List<Lunches>> call, Throwable t) {
//
//            }
//        });
//    }
//
//    public void setRepositoryLunchesList(List<Lunches> repositoryLunchesList) {
//        this.repositoryLunchesList = repositoryLunchesList;
//    }
//
//    public List<Lunches> getRepositoryLunchesList() {
//        return repositoryLunchesList;
//    }
}
