package com.example.weatherapptrial.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.weatherapptrial.Domains.Hourly;
import com.example.weatherapptrial.Domains.TomorrowDomain;
import com.example.weatherapptrial.R;

import java.util.ArrayList;

public class TomorrowAdapter extends RecyclerView.Adapter<TomorrowAdapter.ViewHolder> {


    ArrayList<TomorrowDomain> items;
    Context context;

    public TomorrowAdapter(ArrayList<TomorrowDomain> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public TomorrowAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_tomorrow, parent,false);
        context = parent.getContext();
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull TomorrowAdapter.ViewHolder holder, int position) {
        holder.dayTxt.setText(items.get(position).getDay());
        holder.statusTxt.setText(items.get(position).getStatus());
        holder.lowTemp.setText(items.get(position).getLowTemp()+"°");
        holder.highTemp.setText(items.get(position).getHighTemp()+"°");

        int drawableResourcesId = holder.itemView.getResources()
                .getIdentifier(items.get(position).getPicPath(), "drawable",holder.itemView.getContext().getPackageName());

        Glide.with(context)
                .load(drawableResourcesId)
                .into(holder.pic);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView dayTxt, statusTxt, lowTemp, highTemp;
        ImageView pic;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            dayTxt = itemView.findViewById(R.id.dayTxt);
            statusTxt = itemView.findViewById(R.id.statusTxt);
            lowTemp = itemView.findViewById(R.id.lowTemp);
            highTemp = itemView.findViewById(R.id.highTemp);
            pic = itemView.findViewById(R.id.pic);
        }
    }
}
