package com.example.ashimghimire.network.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.ashimghimire.network.R;
import com.example.ashimghimire.network.UI.LunchesActivity;
import com.example.ashimghimire.network.model.Lunches;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LunchesAdapter extends RecyclerView.Adapter<LunchesAdapter.ViewHolder> {

    private List<Lunches> listLunches;
    private Context context;


    public LunchesAdapter(Context context, List<Lunches> listLunches) {
        this.listLunches = listLunches;
        this.context = context;

        }

    @Override
    public LunchesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_lunches, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull LunchesAdapter.ViewHolder holder, int position) {
        Lunches currentLunches = listLunches.get(holder.getAdapterPosition());
        holder.flightId.setText(String.valueOf(currentLunches.getLunchesFlightNumber()));
        holder.flightDetails.setText(currentLunches.getLunchesMissionName());
        Glide.with(context).load(currentLunches.getLunchesImages().getLunchSmallImageUrl()).apply(LunchesActivity.option).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return listLunches.size();
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



