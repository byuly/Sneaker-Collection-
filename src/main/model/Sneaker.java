package model;


import org.json.JSONObject;
import persistence.Writable;

// Class that represents a sneaker with info.
public class Sneaker implements Writable {
    private double price;
    private double size;
    private String name;
    private Boolean boughtYet;
    private String colorway;


    // EFFECTS: constructs sneaker with given price, size, date, name, and bought status as false.
    public Sneaker(double price, double size, String name, String colorway) {
        this.price = price;
        this.size = size;
        this.name = name;
        this.colorway = colorway;
        this.boughtYet = false;
    }


    // MODIFIES: this
    // EFFECTS: sets the name of sneaker.
    public void setName(String s) {
        this.name = s;
    }

    // MODIFIES: this
    // EFFECTS: sets the price of sneaker.
    public void setPrice(Double n) {
        this.price = n;
    }


    // EFFECTS: sets owned status.
    public void setOwned(Boolean isOwned) {
        this.boughtYet = isOwned;
    }

    // MODIFIES: this
    // EFFECTS: sets the size for the shoe.
    public void setSize(double size) {
        this.size = size;
    }

    // EFFECTS: returns the size for sneaker.
    public double getSize() {
        return this.size;
    }

    // REQUIRES: price > 0.
    // MODIFIES: this
    // EFFECTS: add given price to current price.
    public void increasePrice(double price) {
        this.price += price;
    }

    // REQUIRES: price > 0.
    // MODIFIES: this
    // EFFECTS: subtract given price from current price.
    public void decreasePrice(double price) {
        this.price -= price;
    }

    // EFFECTS: returns the price of sneaker.
    public double getPrice() {
        return this.price;
    }

    // MODIFIES: this
    // EFFECTS: sets the colorway for the sneaker.
    public void setColorway(String colorway) {
        this.colorway = colorway;
    }

    // EFFECTS: returns the colorway for sneaker.
    public String getColorway() {
        return this.colorway;
    }

    // MODIFIES: this
    // EFFECTS: Changes the bought status to true.
    public void boughtWanted() {
        this.boughtYet = true;
    }

    // MODIFIES: this
    // EFFECTS: Changes the bought status to false.
    public void soldOwned() {
        this.boughtYet = false;
    }

    // EFFECTS: returns the owned status of the sneaker.
    public Boolean isBoughtYet() {
        return this.boughtYet;
    }

    // EFFECTS: returns the name of the sneaker.
    public String getName() {
        return this.name;
    }

    // METHOD FROM:
    // https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo/blob/master/src/main/model/Thingy.java
    // EFFECTS: returns sneaker as json file.
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("price", price);
        json.put("size", size);
        json.put("name", name);
        json.put("colorway", colorway);
        json.put("boughtYet", boughtYet);
        return json;
    }
}

