package com.example.restaurants;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

public class RestaurantContentActivity extends AppCompatActivity {

    static private String TAG = "TAG";

    NavController navControllerRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);
        Log.d(TAG, "***onCreate***");

    }



    public void back(){
        navControllerRes = Navigation.findNavController(this, R.id.nav_host_restaurant);

        Log.d(TAG, "button back 1");
        Log.d(TAG, "button back 2 nav = " + navControllerRes);

      //  navController.popBackStack();
        navControllerRes.navigate(R.id.restaurantsFragment);
        Log.d(TAG, "button back 3");

    }
}
