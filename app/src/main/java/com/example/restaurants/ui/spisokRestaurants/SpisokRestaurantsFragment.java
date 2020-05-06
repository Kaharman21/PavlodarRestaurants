package com.example.restaurants.ui.spisokRestaurants;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restaurants.R;
import com.example.restaurants.RestaurantContentActivity;
import com.example.restaurants.ui.Adapters.SpisokRestaurantsAdapter;
import com.example.restaurants.ui.Models.SpisokRestaurantsModel;
import com.example.restaurants.ui.map.MapFragment;

import java.util.ArrayList;
import java.util.List;

public class SpisokRestaurantsFragment extends Fragment {

    private SpisokRestaurantsViewModel spisokRestaurantsViewModel;
    CardView cardViewMap;
    CardView cardViewRestoran;
    List<SpisokRestaurantsModel> listSpisokRestaurants;
    RecyclerView spisokRestaurantsRecyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        spisokRestaurantsViewModel =
                ViewModelProviders.of(this).get(SpisokRestaurantsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_spisok_restaurants, container, false);
        final TextView textView = root.findViewById(R.id.text_home);


        spisokRestaurantsViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });


        cardViewMap = (CardView) root.findViewById(R.id.cardViewMap);
        cardViewMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MapFragment.class);
                startActivity(intent);

            }
        });


        cardViewRestoran = (CardView) root.findViewById(R.id.cardViewRestoran);
        cardViewRestoran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             //   Navigation.findNavController(v).navigate(R.id.restaurantContentActivity);    // чтоб работало activity-restaurantscontent надо добавить в navigation
               // Intent intent = new Intent(getContext(), Test.class);
                  Intent intent = new Intent(getContext(), RestaurantContentActivity.class);
                  startActivity(intent);
            }
        });


        spisokRestaurantsRecyclerView = root.findViewById(R.id.spisokRestaurantRecyclerView);
        listSpisokRestaurants = new ArrayList<>();

        listSpisokRestaurants.add(new SpisokRestaurantsModel("aaaaaaaaa","Гриль-Бар VERANDA","Авторская кухня • \u200BАмериканская кухня\u200B • Домашняя кухня\u200B • Европейская кухня\u200B • Испанская кухня • \u200BКавказская кухня"));
        listSpisokRestaurants.add(new SpisokRestaurantsModel("aaaaaaaaa","Гриль-Бар VERANDA","Авторская кухня • \u200BАмериканская кухня\u200B • Домашняя кухня\u200B • Европейская кухня\u200B • Испанская кухня • \u200BКавказская кухня"));
        listSpisokRestaurants.add(new SpisokRestaurantsModel("aaaaaaaaa","ssssssssssss","s"));

        recyclerViewInit(spisokRestaurantsRecyclerView, listSpisokRestaurants);



        ////////////////////////////////////////R*A*T*I*N*G*//////////////////////////////////////

        final RatingBar smallRatingBar = (RatingBar) root.findViewById(R.id.ratingBar_small);
        final RatingBar indicatorRatingBar = (RatingBar) root.findViewById(R.id.ratingBar_indicator);
        final RatingBar defaultRatingBar = (RatingBar) root.findViewById(R.id.ratingBar_default);

        defaultRatingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {

            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating,
                                        boolean fromUser) {
                smallRatingBar.setRating(rating);
                indicatorRatingBar.setRating(rating);

                Toast.makeText(getContext(), "рейтинг: " + String.valueOf(rating),
                        Toast.LENGTH_LONG).show();
            }
        });

        ////////////////////////////////////////R*A*T*I*N*G* (END) //////////////////////////////////////
        return root;
    }

    private void recyclerViewInit(RecyclerView r, List<SpisokRestaurantsModel> spisokRestaurants){
        r.setLayoutManager(new LinearLayoutManager(getContext()));
        SpisokRestaurantsAdapter spisokRestaurantsAdapter = new SpisokRestaurantsAdapter(getContext(), spisokRestaurants);
        r.setAdapter(spisokRestaurantsAdapter);
    }



}