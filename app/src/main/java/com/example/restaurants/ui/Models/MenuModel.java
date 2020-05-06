package com.example.restaurants.ui.Models;

import androidx.annotation.Nullable;

public class MenuModel {

    String name;
    String description;
    String price;
    String image;
    String textZagolovok;

    public String getTextZagolovok() {
        return textZagolovok;
    }

    public void setTextZagolovok(String textZagolovok) {
        this.textZagolovok = textZagolovok;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public MenuModel(String name, String description, String price, @Nullable String textZagolovok) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
        this.textZagolovok = textZagolovok;
    }
}
