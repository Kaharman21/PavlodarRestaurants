package com.example.restaurants.ui.restaurant;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restaurants.MainActivity;
import com.example.restaurants.R;
import com.example.restaurants.ui.Adapters.RestaurantAdapter;
import com.example.restaurants.ui.Models.RestaurantModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class RestaurantFragment extends Fragment {

    private RestaurantViewModel mViewModel;
    FloatingActionButton floatActBar;
    ImageView back;
    List<RestaurantModel> restaurantList;
    RecyclerView restaurantRecyclerView;


    //TODO Класс НЕ ИСПОЛЬЗУЕТСЯ///////////////////////////////////////////

    public static RestaurantFragment newInstance() {
        return new RestaurantFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_restaurant, container, false);
        floatActBar = (FloatingActionButton) root.findViewById(R.id.floating_restaurants);
        floatActBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.menuFragment);

            }
        });

        back = root.findViewById(R.id.image_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);  //убиваем ACtivity при перемещении
                startActivity(intent);            }
        });


        restaurantList = new ArrayList<>();
        restaurantRecyclerView = root.findViewById(R.id.restaurantRecyclerView);

        restaurantList.add(new RestaurantModel("aaaa","sss"));
        restaurantList.add(new RestaurantModel("aaaa","ss"));
        restaurantList.add(new RestaurantModel("aaaa","s"));

        recyclerViewInit(restaurantRecyclerView,restaurantList);

        return root;
    }


    private void recyclerViewInit(RecyclerView r, List<RestaurantModel> restaurant){
        r.setLayoutManager(new LinearLayoutManager(getContext()));
        RestaurantAdapter restaurantFragmentAdapter = new RestaurantAdapter(getContext(), restaurant);
        r.setAdapter(restaurantFragmentAdapter);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(RestaurantViewModel.class);
        // TODO: Use the ViewModel
    }

}
