package com.example.restaurants;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.restaurants.ui.spisokRestaurants.SpisokRestaurantsFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    SpisokRestaurantsFragment homeFragment;
    static private String TAG = "TAG";
    int exit =0;                                     // Выход по двойному щелчку
    DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });



         drawer = findViewById(R.id.drawer_layout);   // Весь MainActivity
        NavigationView navigationView = findViewById(R.id.nav_view);  // Только выезжающая шторка
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
                R.id.nav_tools, R.id.nav_share, R.id.nav_send)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        Log.d(TAG, "MainActivity nav = " + navController);

        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);    // если убрать, то исчезает кнопка меню (сэндвич)
        NavigationUI.setupWithNavController(navigationView, navController);          //  если убрать, то не обрабатывается нажатие на пункты меню
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
       // getMenuInflater().inflate(R.menu.main, menu);                              // Убрал меню с правой стороны (три точки)
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


    @Override
    public void onBackPressed() {
       // super.onBackPressed();        // Убрал для того чтобы back работал коректно
        exit = exit +1;
        Log.d(TAG,"exit = " + exit);
        if (exit==1){
            Snackbar.make(drawer, "Для выхода нажмите назад еще раз", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
                    }
        else {
            finish();
        }

    }
}
