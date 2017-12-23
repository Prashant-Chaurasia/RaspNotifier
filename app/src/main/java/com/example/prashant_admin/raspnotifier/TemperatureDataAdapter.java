package com.example.prashant_admin.raspnotifier;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by prashant-admin on 20/12/17.
 */

public class TemperatureDataAdapter extends RecyclerView.Adapter<TemperatureDataViewHolder>{

    private List<TemperatureData> temperatureDataList;
    protected Context context;
    public TemperatureDataAdapter(Context context, List<TemperatureData> temperatureDataList) {
        this.temperatureDataList = temperatureDataList;
        this.context = context;
    }
    @Override
    public TemperatureDataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        TemperatureDataViewHolder viewHolder = null;
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_data, parent, false);
        viewHolder = new TemperatureDataViewHolder(layoutView, temperatureDataList);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(TemperatureDataViewHolder holder, int position) {
        String key = temperatureDataList.get(position).getKey();
        String tempData = temperatureDataList.get(position).getTemperature()+" \u2103";
        holder.temperatureTextView.setText(tempData);
        holder.messageTextView.setText(temperatureDataList.get(position).getMessage());
        holder.dateTextView.setText(temperatureDataList.get(position).getDate());
    }
    @Override
    public int getItemCount() {
        return this.temperatureDataList.size();
    }
}

