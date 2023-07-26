package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.lang.reflect.Array;
import java.util.ArrayList;

// Class contains list of sneakers, owned sneakers, and wanted sneakers.
public class SneakerList implements Writable {
    private ArrayList<Sneaker> sneakers;
    private ArrayList<Sneaker> sneakersWant;
    private ArrayList<Sneaker> sneakersOwn;

    public SneakerList() {
        this.sneakers = new ArrayList<>();
        this.sneakersWant = new ArrayList<>();
        this.sneakersOwn = new ArrayList<>();

    }

    // EFFECTS: returns universal sneaker list.
    public ArrayList<Sneaker> getSneakers() {
        return sneakers;
    }

    // EFFECTS: returns universal sneaker list with name.
    public ArrayList<String> getSneakerList() {
        ArrayList<String> printedList = new ArrayList<>();
        for (Sneaker sneaker: sneakers) {
            printedList.add(sneaker.getName());
        }
        return printedList;
    }


    // EFFECTS: returns "wanted" sneaker list by name.
    public ArrayList<String> getSneakerWantList() {
        ArrayList<String> printedList = new ArrayList<>();
        for (Sneaker sneaker: sneakersWant) {
            printedList.add(sneaker.getName());
        }
        return printedList;
    }

    // EFFECTS: returns "owned" sneaker list.
    public ArrayList<String> getSneakerOwnList() {
        ArrayList<String> printedList = new ArrayList<>();
        for (Sneaker sneaker: sneakersOwn) {
            printedList.add(sneaker.getName());
        }
        return printedList;
    }


    // MODIFIES: this
    // EFFECTS: adds sneaker to universal sneaker list.
    public void addSneaker(Sneaker sneaker) {
        sneakers.add(sneaker);
        if (sneaker.isBoughtYet()) {
            this.sneakersOwn.add(sneaker);
        } else {
            this.sneakersWant.add(sneaker);
        }
    }


    // MODIFIES: this
    // EFFECTS: removes sneaker from all lists.
    public void removeSneaker(Sneaker sneaker) {
        if (sneakers.contains(sneaker)) {
            sneakers.remove(sneaker);
        }
        if (sneakersWant.contains(sneaker)) {
            sneakersWant.remove(sneaker);
        }
        if (sneakersOwn.contains(sneaker)) {
            sneakersOwn.remove(sneaker);
        }
    }

    // MODIFIES: this
    // EFFECTS: clears all the lists.
    public void clearSneakerList() {
        sneakers.clear();
        sneakersWant.clear();
        sneakersOwn.clear();
    }

  /*  // MODIFIES: this
    // EFFECTS: refreshes all lists so any new sneakers added will be allocated to appropriate lists.
    public void refreshCollections() {
        for (Sneaker sneaker : sneakers) {
            if (sneaker.isBoughtYet()) {
                this.sneakersOwn.add(sneaker);
            } else {
                this.sneakersWant.add(sneaker);
            }
        }
    }*/

    // EFFECTS: produces a list of sneakers names that are searched by name.
    public ArrayList<String> getSneakerSearch(String s) {
        ArrayList<Sneaker> listSneakerSearch = new ArrayList<>();
        for (Sneaker sneaker : this.sneakers) {
            if (sneaker.getName().contains(s)) {
                listSneakerSearch.add(sneaker);
            }
        }
        ArrayList<String> printedList = new ArrayList<>();
        for (Sneaker sneaker: listSneakerSearch) {
            printedList.add(sneaker.getName());
        }
        return printedList;
    }

    // REQUIRES: list is one element long.
    // EFFECTS: returns the sneaker model with name.
    public Sneaker getOneSneaker(ArrayList<String> oneLong) {
        for (Sneaker sneaker: this.sneakers) {
            if (sneaker.getName().contains(oneLong.get(0))) {
                return sneaker;
            }
        }
        return null;
    }


    //EFFECTS: return arraylist of names of shoes.
    public ArrayList<String> listOfNames() {
        ArrayList<String> names = new ArrayList<>();

        for (Sneaker sneaker : this.sneakers) {
            names.add(sneaker.getName());
        }

        return names;
    }

    // NEXT TWO METHODS FROM:
    // https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo/blob/master/src/main/model/WorkRoom.java
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("sneakers", sneakersToJson());
        return json;
    }

    // EFFECTS: returns things in this workroom as a JSON array
    private JSONArray sneakersToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Sneaker s : sneakers) {
            jsonArray.put(s.toJson());
        }

        return jsonArray;
    }
}
