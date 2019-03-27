package com.example.ashimghimire.network.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.bumptech.glide.request.RequestOptions;
import com.example.ashimghimire.network.R;
import com.example.ashimghimire.network.ui.Launches.FragmentLaunches;
import com.example.ashimghimire.network.ui.launchinfo.FragmentLaunchInfo;

public class LaunchActivity extends AppCompatActivity implements InteractionListener {
    public static  RequestOptions option;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launches);
        option = new RequestOptions().centerCrop().placeholder(R.drawable.ic_launcher_background).error(R.drawable.ic_launcher_background);
        showDefaultFragment();
    }

    @Override
    public void navigateToDetails(int flightNumber) {
        getSupportFragmentManager().beginTransaction().replace(R.id.lunches_fragment_container, FragmentLaunchInfo.newInstance(flightNumber)).commit();
    }

    @Override
    public void showDefaultFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.lunches_fragment_container, FragmentLaunches.newInstance()).commit();
    }

    @Override
    public void pop() {
    }
}
