package model;


public class Sneaker {
    private double price;
    private double size;
    private DateForSneaker dateform;
    private String date;
    private String name;
    private Boolean boughtyet;
    private String colorway;


    // EFFECTS: constructs sneaker with given price, size, date and name.
    public Sneaker(double price, double size, String name, String colorway) {
        this.price = price;
        this.size = size;
        this.date = "";
        this.name = name;
        this.colorway = colorway;
        this.boughtyet = false;
    }

    public void setDate(DateForSneaker dateform) {
        this.date = dateform.dateToString();
    }

    public String getDate() {
        return this.date;
    }

    //MODIFIES: this
    //EFFECTS: sets the size for the shoe.
    public void setSize(double size) {
        this.size = size;
    }

    public double getSize() {
        return this.size;
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
        this.price -= price;
    }

    public double getPrice() {
        return this.price;
    }

    public void setColorway(String colorway) {
        this.colorway = colorway;
    }

    public String getColorway() {
        return this.colorway;
    }

    public void boughtWanted() {
        this.boughtyet = true;
    }

    public void soldOwned() {
        this.boughtyet = false;
    }

    public Boolean isBoughtYet() {
        return this.boughtyet;
    }

    public String getName() {
        return this.name;
    }


}

