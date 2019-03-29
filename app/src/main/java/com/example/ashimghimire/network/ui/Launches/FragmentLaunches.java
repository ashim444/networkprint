package com.example.ashimghimire.network.ui.Launches;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ashimghimire.network.R;
import com.example.ashimghimire.network.databinding.FragmentLaunchesBinding;
import com.example.ashimghimire.network.model.Launch;
import com.example.ashimghimire.network.networking.LaunchApiRepository;
import com.example.ashimghimire.network.ui.InteractionListener;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentLaunches extends Fragment {
    InteractionListener listener;
    FragmentLaunchesBinding launchesBinding;

    public static FragmentLaunches newInstance() {
        return new FragmentLaunches();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        launchesBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_launches, container, false);
        return launchesBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View v, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(v, savedInstanceState);

        Call<List<Launch>> lunches = LaunchApiRepository.getLaunchApi().getLunches();
        lunches.enqueue(new Callback<List<Launch>>() {
            @Override
            public void onResponse(Call<List<Launch>> call, Response<List<Launch>> response) {
                if (!response.isSuccessful()) {
                    return;
                }
                generateLunchesList(response.body());
            }

            @Override
            public void onFailure(Call<List<Launch>> call, Throwable t) {
                //TODO couter failer case
            }
        });
    }

    public void generateLunchesList(final List<Launch> list) {
//      launchList = list;
        launchesBinding.lunchesRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        LaunchAdapter adapter = new LaunchAdapter(getContext());
        adapter.setListLaunches(list);
        launchesBinding.lunchesRecycler.setAdapter(adapter);
        adapter.setOnItemClickListener(new LaunchAdapter.OnItemClickListener() {
            @Override
            public void getClickLunches(int position) {
                listener.navigateToDetails(list.get(position).getLunchesFlightNumber());
            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof InteractionListener) {
            listener = (InteractionListener) context;
        } else {
            throw new RuntimeException() {
            };
        }
    }

}
