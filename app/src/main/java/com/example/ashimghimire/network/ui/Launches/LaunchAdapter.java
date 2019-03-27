package com.example.ashimghimire.network.ui.Launches;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ashimghimire.network.R;
import com.example.ashimghimire.network.model.Launch;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LaunchAdapter extends RecyclerView.Adapter<LaunchAdapter.ViewHolder> {

    private List<Launch> listLaunches = new ArrayList<>();
    private Context context;

    public LaunchAdapter(Context context) {
        this.context = context;
    }

    @Override
    public LaunchAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_launches, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull LaunchAdapter.ViewHolder holder, int position) {
        Launch currentLaunch = listLaunches.get(holder.getAdapterPosition());
        holder.flightId.setText(String.valueOf(currentLaunch.getLunchesFlightNumber()));
        holder.flightDetails.setText(currentLaunch.getLunchesMissionName());
        Glide.with(context).load(currentLaunch.getLaunchImages().getLunchesSmallImageUrl()).placeholder(R.drawable.ic_launcher_background).into(holder.imageView);
    }

    public void setListLaunches(List<Launch> listLaunches) {
        this.listLaunches = listLaunches;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return listLaunches.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView flightId, flightDetails;
        public ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            flightId = (TextView) itemView.findViewById(R.id.item_lunches_flight_text_view);
            flightDetails = (TextView) itemView.findViewById(R.id.item_lunches_flight_details);
            imageView = (ImageView) itemView.findViewById(R.id.item_lunches_image);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onItemClickListener != null && getAdapterPosition() != RecyclerView.NO_POSITION) {
                        onItemClickListener.getClickLunches(getAdapterPosition());
                    }
                }
            });
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void getClickLunches(int position);
    }
}



