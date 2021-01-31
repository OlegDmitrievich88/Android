package com.geekbrains.onlinelessons.android.one.weatherapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterForRecyclerView extends RecyclerView.Adapter<AdapterForRecyclerView.ViewHolder> {
    public ArrayList<String> data;
        public AdapterForRecyclerView(ArrayList<String> data){
                this.data = data;
        }

        private void setText(@NonNull ViewHolder holder, String text){
                holder.textForecast.setText(text);
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.text_for_forecast,parent,false);
                return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
                setText(holder,data.get(position));
        }


        @Override
        public int getItemCount() {
                return data == null? 0: data.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder{
                FrameLayout textForForecast;
                TextView textForecast;

                public ViewHolder (@NonNull View itemView){
                        super(itemView);
                        textForForecast = itemView.findViewById(R.id.textForForecast);
                        textForecast = itemView.findViewById(R.id.textForecast);

                }
        }

}
