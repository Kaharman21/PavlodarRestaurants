package com.example.restaurants.ui.Models;

public class RestaurantModel {

    String name;
    String Image;

    public RestaurantModel(String name, String image) {
        this.name = name;
        Image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }
}
