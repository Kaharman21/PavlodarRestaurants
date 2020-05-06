package com.example.restaurants.ui.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restaurants.R;
import com.example.restaurants.ui.Models.MenuModel;

import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> {

    private LayoutInflater inflater;
    Context mContext;
    List<MenuModel> menuList;

    public MenuAdapter(Context mContext, List<MenuModel> menuList) {
        this.mContext = mContext;
        this.menuList = menuList;
    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.item_menu, parent, false);
        return new MenuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
        MenuModel menu = menuList.get(position);
        holder.name.setText(menu.getName());
        holder.description.setText(menu.getDescription());
        holder.price.setText(menu.getPrice());
        holder.textZagolovok.setText(menu.getTextZagolovok());
        if (menu.getTextZagolovok().equals("")){
            holder.textZagolovok.setVisibility(View.GONE);
        }   else    {
            holder.textZagolovok.setVisibility(View.VISIBLE);

        }
        if (menu.getName().equals("")){
            holder.name.setVisibility(View.GONE);
        }

        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.dishFragment);
             //   Navigation.findNavController(v).popBackStack();
            }
        });
       // Glide.with(mContext).load(menu.getImage()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return menuList.size();
    }





    public class MenuViewHolder extends RecyclerView.ViewHolder{

        TextView textZagolovok;
        TextView name;
        TextView description;
        TextView price;
        ImageView image;

        public MenuViewHolder(@NonNull View itemView) {
            super(itemView);

            textZagolovok = itemView.findViewById(R.id.text_zagolovok);
            name =itemView.findViewById(R.id.name);
            description =itemView.findViewById(R.id.description);
            price =itemView.findViewById(R.id.price);
            image =itemView.findViewById(R.id.image);
        }
    }
}
