package com.example.ashimghimire.network.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.bumptech.glide.request.RequestOptions;
import com.example.ashimghimire.network.InteractionListener;
import com.example.ashimghimire.network.R;

public class LunchesActivity extends AppCompatActivity implements InteractionListener {
    public static  RequestOptions option;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lunches);
        option = new RequestOptions().centerCrop().placeholder(R.drawable.ic_launcher_background).error(R.drawable.ic_launcher_background);

        showDefaultFragment();
    }

    @Override
    public void navigateToDetails(int clickedPosition) {
        getSupportFragmentManager().beginTransaction().replace(R.id.lunches_fragment_container, FragmentLunchesInfo.newInstance(clickedPosition)).commit();
    }

    @Override
    public void showDefaultFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.lunches_fragment_container, FragmentLunches.newInstance()).commit();
    }

    @Override
    public void pop() {

    }
}
