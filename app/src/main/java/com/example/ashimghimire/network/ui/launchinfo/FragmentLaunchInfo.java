package com.example.ashimghimire.network.ui.launchinfo;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ashimghimire.network.R;
import com.example.ashimghimire.network.model.Launch;
import com.example.ashimghimire.network.networking.LaunchApiRepository;
import com.example.ashimghimire.network.ui.InteractionListener;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentLaunchInfo extends Fragment {
    private InteractionListener interactionListener;
    public static final String LUNCHES_POSITION = "position";
    private ImageView lunchesImage;
    private TextView flightName, flightDetail;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        int i = getArguments().getInt(LUNCHES_POSITION);
        lunchesImage = view.findViewById(R.id.lunches_info_big_image);
        flightName = view.findViewById(R.id.lunches_info_flight_num);
        flightDetail = view.findViewById(R.id.lunches_info_name);
        Call<Launch> call = LaunchApiRepository.getLaunchApi().getOneLaunch(i);
        call.enqueue(new Callback<Launch>() {
            @Override
            public void onResponse(Call<Launch> call, Response<Launch> response) {
                generateLunchesList(response.body());
            }
            @Override
            public void onFailure(Call<Launch> call, Throwable t) {
                flightName.setText("Fail");
            }
        });
    }

    void generateLunchesList(Launch currentLaunch) {
        Glide.with(getContext()).load(currentLaunch.getLaunchImages().getLunchesBigImageUrl()).placeholder(R.drawable.ic_launcher_background).into(lunchesImage);
        flightName.setText(currentLaunch.getLunchesMissionName());
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
        return inflater.inflate(R.layout.fragment_launches_info, container, false);
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
