package model;

import java.util.ArrayList;
import java.util.List;

public class SneakerList {
    private ArrayList<Sneaker> sneakers;
    private ArrayList<Sneaker> sneakerWant;
    private ArrayList<Sneaker> sneakerOwn;

    public SneakerList() {
        this.sneakers = new ArrayList<>();
        this.sneakerWant = new ArrayList<>();
        this.sneakerOwn = new ArrayList<>();

    }

    // EFFECTS: returns universal sneaker list.
    public ArrayList<Sneaker> getSneakerList() {
        return sneakers;
    }

    // EFFECTS: returns "wanted" sneaker list.
    public ArrayList<Sneaker> getSneakerWantList() {
        return sneakerWant;
    }

    // EFFECTS: returns "owned" sneaker list.
    public ArrayList<Sneaker> getSneakerOwnList() {
        return sneakerOwn;
    }

    // MODIFIES: this
    // EFFECTS: adds sneaker to universal sneaker list.
    public void addSneaker(Sneaker sneaker) {
        sneakers.add(sneaker);
    }

    // MODIFIES: this
    // EFFECTS: removes sneaker from all lists.
    public void removeSneaker(Sneaker sneaker) {
        if (sneakers.contains(sneaker)) {
            sneakers.remove(sneaker);
        }
        if (sneakerWant.contains(sneaker)) {
            sneakerWant.remove(sneaker);
        }
        if (sneakerOwn.contains(sneaker)) {
            sneakerOwn.remove(sneaker);
        }
    }

    // MODIFIES: this
    // EFFECTS: clears all the lists.
    public void clearSneakerList() {
        sneakers.clear();
        sneakerWant.clear();
        sneakerOwn.clear();
    }

    // MODIFIES: this
    // EFFECTS: refreshes all lists so any new sneakers added will be allocated to appropriate lists.
    public void refreshCollections() {
        for (Sneaker sneaker : sneakers) {
            if (sneaker.isBoughtYet()) {
                this.sneakerOwn.add(sneaker);
            } else {
                this.sneakerWant.add(sneaker);
            }
        }
    }

    // EFFECTS: produces a list of sneakers that are searched by name.
    public ArrayList<Sneaker> getSneakerSearch(String s) {
        ArrayList<Sneaker> listSneakerSearch = new ArrayList<>();
        for (Sneaker sneaker : this.sneakers) {
            if (sneaker.getName().contains(s)) {
                listSneakerSearch.add(sneaker);
            }
        }
        return listSneakerSearch;
    }


    //EFFECTS: return arraylist of names of shoes.
    public ArrayList<String> listOfNames() {
        ArrayList<String> names = new ArrayList<>();

        for (Sneaker sneaker : this.sneakers) {
            names.add(sneaker.getName());
        }

        return names;
    }

}
