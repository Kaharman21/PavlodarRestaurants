package com.example.restaurants.ui.Adapters;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restaurants.R;
import com.example.restaurants.ui.Models.RestaurantModel;

import java.util.List;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder>{

    Context mContext;
    List<RestaurantModel> restaurantList;

    public RestaurantAdapter(Context mContext, List<RestaurantModel> restaurantList) {
        this.mContext = mContext;
        this.restaurantList = restaurantList;
    }

    @NonNull
    @Override
    public RestaurantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.item_restaurant, parent, false);
        return new RestaurantViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantViewHolder holder, int position) {
        RestaurantModel restaurantModel = restaurantList.get(position);
        holder.nameRazdela.setText(restaurantModel.getName());

        final Bundle bundle = new Bundle();
        bundle.putString("nameRazdela", String.valueOf(holder.nameRazdela.getText()));

        holder.nameRazdela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.menuFragment, bundle);

            }
        });
    }

    @Override
    public int getItemCount() {
        return restaurantList.size();
    }





    public class RestaurantViewHolder extends RecyclerView.ViewHolder{

        TextView nameRazdela;
        ImageView imageRazdela;

        public RestaurantViewHolder(@NonNull View itemView) {
            super(itemView);

            nameRazdela =itemView.findViewById(R.id.name_razdela);
            imageRazdela =itemView.findViewById(R.id.image_razdela);
        }
    }
}
