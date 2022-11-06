package com.example.androidproject;

public class userhelper {
    String  Item;
    int quantity;
    int price;

    public userhelper( String item, int quantity, int price) {

        Item = item;
        this.quantity = quantity;
        this.price = price;
    }





    public String getItem() {
        return Item;
    }

    public void setItem(String item) {
        Item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}