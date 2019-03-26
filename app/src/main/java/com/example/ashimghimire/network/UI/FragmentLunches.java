package com.example.ashimghimire.network.UI;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ashimghimire.network.InteractionListener;
import com.example.ashimghimire.network.adapter.LunchesAdapter;
import com.example.ashimghimire.network.LunchesApiRepository;
import com.example.ashimghimire.network.R;
import com.example.ashimghimire.network.model.Lunches;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentLunches extends Fragment {
    InteractionListener listener;
    public  static  List<Lunches> lunchesList;
    private RecyclerView recyclerView;

    public static FragmentLunches newInstance() {
        return new FragmentLunches();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_lunches, container, false);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View v, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(v, savedInstanceState);
        recyclerView = v.findViewById(R.id.lunches_recycler);

        Call<List<Lunches>> lunches = LunchesApiRepository.getLunchesApi().getLunches();
        lunches.enqueue(new Callback<List<Lunches>>() {
            @Override
            public void onResponse(Call<List<Lunches>> call, Response<List<Lunches>> response) {
                if (!response.isSuccessful()) {
                    return;
                }
                generateLunchesList(response.body());
            }
            @Override
            public void onFailure(Call<List<Lunches>> call, Throwable t) {

            }
        });

    }

    public void generateLunchesList(List<Lunches> list) {
        lunchesList = list;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        LunchesAdapter adapter = new LunchesAdapter(getContext(),list);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new LunchesAdapter.OnItemClickListener() {
            @Override
            public void getClickLunches(int position) {
                listener.navigateToDetails(position);
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
