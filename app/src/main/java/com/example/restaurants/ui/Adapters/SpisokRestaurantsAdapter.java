package com.example.restaurants.ui.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restaurants.R;
import com.example.restaurants.ui.Models.SpisokRestaurantsModel;

import java.util.List;

public class SpisokRestaurantsAdapter extends RecyclerView.Adapter<SpisokRestaurantsAdapter.SpisokRestaurantsViewHolder>{

    Context mContext;
    List<SpisokRestaurantsModel> listSpisokRestaurants;


    public SpisokRestaurantsAdapter(Context mContext, List<SpisokRestaurantsModel> listSpisokRestaurants) {
        this.mContext = mContext;
        this.listSpisokRestaurants = listSpisokRestaurants;
    }


    @NonNull
    @Override
    public SpisokRestaurantsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.item_spisok_restaurants, parent, false);
        return new SpisokRestaurantsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SpisokRestaurantsViewHolder holder, int position) {
        SpisokRestaurantsModel spisokRestaurantsModel = listSpisokRestaurants.get(position);
        holder.name.setText(spisokRestaurantsModel.getName());
        holder.description.setText(spisokRestaurantsModel.getDescription());

    }

    @Override
    public int getItemCount() {
        return listSpisokRestaurants.size();
    }






    public class SpisokRestaurantsViewHolder extends RecyclerView.ViewHolder{

        TextView name;
        TextView description;
        ImageView image;

        public SpisokRestaurantsViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name_spisok_restaurants);
            description = itemView.findViewById(R.id.description_spisok_restaurants);
            image = itemView.findViewById(R.id.image_spisok_restaurants);
        }
    }
}
