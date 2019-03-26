package com.example.ashimghimire.network.UI;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ashimghimire.network.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentLunchesInfo extends Fragment {
    public static final String LUNCHES_POSITION = "position";
    private ImageView lunchesImage;


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        int i = getArguments().getInt(LUNCHES_POSITION);
        lunchesImage = view.findViewById(R.id.lunches_info_big_image);
        Glide.with(getContext()).load(FragmentLunches.lunchesList.get(i).getLunchesImages().getLunchSmallImageUrl()).apply(LunchesActivity.option).into(lunchesImage);
        ((TextView)(view.findViewById(R.id.lunches_info_flight_num))).setText(FragmentLunches.lunchesList.get(i).getLunchesMissionName());
    }

    public static FragmentLunchesInfo newInstance(int lunches){
        Bundle args = new Bundle();
        FragmentLunchesInfo fragmentLunchesInfo = new FragmentLunchesInfo();
        args.putInt(LUNCHES_POSITION, lunches);
        fragmentLunchesInfo.setArguments(args);
        return fragmentLunchesInfo;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_lunches_info, container, false);
    }


}
