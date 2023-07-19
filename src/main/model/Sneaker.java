package model;

import java.text.DateFormat;

public class Sneaker {
    private double price;
    private double size;
    private String date;
    private String name;
    private Boolean own;

    // EFFECTS: constructs sneaker with given price, size, date and name.
    public Sneaker(double price, double size, String date, String name) {
        this.price = price;
        this.size = size;
        this.date = date;
        this.name = name;
        this.own = false;
    }

    public void setDate(DateFormat date) {

    }
    //MODIFIES: this
    //EFFECTS: sets the size for the shoe.
    public void setSize(int size) {
        this.size = size;
    }

    //REQUIRES: price > 0.
    //MODIFIES: this
    //EFFECTS: add given price to current price.
    public void increasePrice(double price) {
        this.price += price;
    }

    //REQUIRES: price > 0.
    //MODIFIES: this
    //EFFECTS: subtract given price from current price.
    public void decreasePrice(double price) {
        this.price += price;
    }


}

