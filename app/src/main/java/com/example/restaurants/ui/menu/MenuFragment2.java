package com.example.restaurants.ui.menu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restaurants.R;
import com.example.restaurants.RestaurantContentActivity;
import com.example.restaurants.ui.Adapters.MenuAdapter;
import com.example.restaurants.ui.Models.MenuModel;

import java.util.ArrayList;
import java.util.List;

public class MenuFragment2 extends Fragment {

    static private String TAG = "TAG";
    List<MenuModel> menuList;
    private MenuViewModel2 mViewModel;
    RecyclerView menuRecyclerView;
    RestaurantContentActivity restaurantContentActivity;
    ImageView imgFood;
    String nameRazdela;    // сюда приходит инфа с класса RestaurantAdapter. Инфа о названии выбранного раздела в toolbar



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_menu2, container, false);
        restaurantContentActivity = new RestaurantContentActivity();

        //TODO      nameRazdela = getArguments().getString("nameRazdela");       Инфа о названии выбранного раздела в toolbar
        //      toolbarMenu.setTitle(nameRazdela);



        menuList = new ArrayList<>();
        menuRecyclerView = root.findViewById(R.id.menuRecyclerView);

        menuList.add(new MenuModel("Тигровые креветки","Креветки тигровые, соевый соус, чеснок","1000 тг","Горячие блюда"));
        menuList.add(new MenuModel("Сельдь \"под стопочку\"","Филе сельди с отварным картофелем, соленым огурцом, луком, ароматным маслом и зеленью","1400 тг","ООоооо"));
        menuList.add(new MenuModel("Антипасти из мясных деликатесов","Тонко нарезанные кусочки филе утиной грудки с/к, филе окорока оленя с/к с можжевельником, говяжьего балыка с/к Подаютя с багетом, оливками гигант и вялеными томатами","2200 тг",""));
        menuList.add(new MenuModel("Тарелка свежих овощей с зеленью","Помидоры, свежий огурец, редис, болгарский перец, лук зеленый, укроп, кинза","3000 тг","Холодные закуски"));
        menuList.add(new MenuModel("aaaaaaaaa","sssssssssss","sssssssssss",""));
        menuList.add(new MenuModel("aaaaaaaaa","sssssssssss","sssssssssss",""));
        menuList.add(new MenuModel("aaaaaaaaa","sssssssssss","sssssssssss",""));
        menuList.add(new MenuModel("aaaaaaaaa","sssssssssss","sssssssssss",""));
        menuList.add(new MenuModel("aaaaaaaaa","sssssssssss","sssssssssss","ааааааааааа"));
        menuList.add(new MenuModel("aaaaaaaaa","sssssssssss","sssssssssss",""));
        menuList.add(new MenuModel("aaaaaaaaa","sssssssssss","sssssssssss",""));
        menuList.add(new MenuModel("end","end","end",""));





        recyclerViewInit(menuRecyclerView, menuList);

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MenuViewModel2.class);
        // TODO: Use the ViewModel
    }


    private void recyclerViewInit(RecyclerView r, List<MenuModel> menu){
        r.setLayoutManager(new LinearLayoutManager(getContext()));
        MenuAdapter menuAdapter = new MenuAdapter(getContext(), menu);
        r.setAdapter(menuAdapter);
    }

}
