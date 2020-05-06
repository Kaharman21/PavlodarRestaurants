package com.example.restaurants.ui.spisokRestaurants;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SpisokRestaurantsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public SpisokRestaurantsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}