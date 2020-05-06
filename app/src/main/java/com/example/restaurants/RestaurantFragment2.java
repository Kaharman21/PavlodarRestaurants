package com.example.restaurants;

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
import androidx.viewpager.widget.ViewPager;

import com.example.restaurants.ui.Models.RestaurantModel;
import com.example.restaurants.ui.menu.MenuFragment2;
import com.example.restaurants.ui.restaurant.RestaurantFragment;
import com.example.restaurants.ui.restaurant.RestaurantViewModel;
import com.example.restaurants.ui.send.SendFragment;
import com.example.restaurants.ui.share.ShareFragment;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class RestaurantFragment2 extends Fragment {

    private TabLayout tabLayout;
    private AppBarLayout appBarLayout;
    private ViewPager viewPager;

    private RestaurantViewModel mViewModel;
    FloatingActionButton floatActBar;
    ImageView back;
    List<RestaurantModel> restaurantList;


    public static RestaurantFragment newInstance() {
        return new RestaurantFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_restaurant2, container, false);
//        floatActBar = (FloatingActionButton) root.findViewById(R.id.floating_restaurants);
//        floatActBar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Navigation.findNavController(v).navigate(R.id.menuFragment);
//
//            }
//        });

        back = root.findViewById(R.id.image_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);  //убиваем ACtivity при перемещении
                startActivity(intent);            }
        });


        restaurantList = new ArrayList<>();

        restaurantList.add(new RestaurantModel("aaaa","sss"));
        restaurantList.add(new RestaurantModel("aaaa","ss"));
        restaurantList.add(new RestaurantModel("aaaa","s"));


        tabLayout = (TabLayout) root.findViewById(R.id.tablayout_id);
        viewPager = (ViewPager) root.findViewById(R.id.viewpager_id);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getFragmentManager(),0);
        adapter.addFragment(new MenuFragment2(), "Меню");
        adapter.addFragment(new SendFragment(),"Акции");
        adapter.addFragment(new ShareFragment(),"Отзывы");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        //////////////////////УСТАНАВЛИВАЕМ ВЫСОТЫ ViewPager//////////
        ViewGroup.LayoutParams params = viewPager.getLayoutParams();
        params.height= (int) (viewPager.getResources().getDisplayMetrics().density * 5*130); // в пикселях (5*130)
        viewPager.setLayoutParams(params);
        /////////////////////////////////////////////////////////////////////




//tabLayout.getTabAt(1).setIcon(R.mipmap.ic_launcher);

        BadgeDrawable badgeDrawable = tabLayout.getTabAt(2).getOrCreateBadge();
        badgeDrawable.setVisible(true);
        badgeDrawable.setNumber(21);


        return root;
    }




    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(RestaurantViewModel.class);
        // TODO: Use the ViewModel
    }

}
