package com.example.ashimghimire.network.ui.launchinfo;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ashimghimire.network.R;
import com.example.ashimghimire.network.databinding.FragmentLaunchesInfoBinding;
import com.example.ashimghimire.network.model.Launch;
import com.example.ashimghimire.network.networking.LaunchApiRepository;
import com.example.ashimghimire.network.ui.InteractionListener;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentLaunchInfo extends Fragment {
    private InteractionListener interactionListener;
    private FragmentLaunchesInfoBinding fragmentLaunchesBinding;
    public static final String LUNCHES_POSITION = "position";

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        int i = getArguments().getInt(LUNCHES_POSITION);
        Call<Launch> call = LaunchApiRepository.getLaunchApi().getOneLaunch(i);
        call.enqueue(new Callback<Launch>() {
            @Override
            public void onResponse(Call<Launch> call, Response<Launch> response) {
                fragmentLaunchesBinding.setOneLaunch(response.body());
                //fragmentLaunchesBinding.setImageUrl(response.body().getLaunchImages().getLunchesBigImageUrl());
            }

            @Override
            public void onFailure(Call<Launch> call, Throwable t) {
                fragmentLaunchesBinding.lunchesInfoName.setText("Failed");
            }
        });
    }

    public static FragmentLaunchInfo newInstance(int lunches) {
        Bundle args = new Bundle();
        FragmentLaunchInfo fragmentLaunchInfo = new FragmentLaunchInfo();
        args.putInt(LUNCHES_POSITION, lunches);
        fragmentLaunchInfo.setArguments(args);
        return fragmentLaunchInfo;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentLaunchesBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_launches_info,
                container, false);
        return fragmentLaunchesBinding.getRoot();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof InteractionListener) {
            interactionListener = (InteractionListener) context;
        } else {
            throw new RuntimeException() {
            };
        }
    }
}
