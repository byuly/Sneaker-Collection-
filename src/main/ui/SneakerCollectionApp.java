package ui;

import model.Sneaker;
import model.SneakerList;

import java.util.ArrayList;
import java.util.Scanner;

public class SneakerCollectionApp {
    private Scanner input;
    private SneakerList sneakers;

    // EFFECTS: runs the Sneaker Collection application
    public SneakerCollectionApp() {
        runSneakers();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void runSneakers() {
        boolean keepGoing = true;
        String command = null;

        init();

        while (keepGoing) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("q")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }

        System.out.println("\nGoodbye!");
    }

    // MODIFIES: this
    // EFFECTS: initializes accounts
    private void init() {
        sneakers = new SneakerList();
        input = new Scanner(System.in);
        input.useDelimiter("\n");
    }

    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand(String command) {
        if (command.equals("s")) {
            doAddSneaker();
        } else if (command.equals("w")) {
            doViewWants();
        } /*else if (command.equals("o")) {
            doViewOwned();
        } else if (command.equals("a")) {
            doViewAll();
        } */else {
            System.out.println("Selection not valid...");
        }
    }

    // EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\ts -> add sneaker");
        System.out.println("\tw -> view list of wanted sneakers");
        System.out.println("\to -> view list of owned sneakers");
        System.out.println("\tq -> view all sneakers");
    }

    // MODIFIES: this
    // EFFECTS: adds sneaker
    private void doAddSneaker() {
        String name = askName();
        Double price = askPrice();
        Double size = askSize();
        String colorway = askColorWay();

        Sneaker s = new Sneaker(price, size, name, colorway);
        s.setOwned(askOwn());
        sneakers.addSneaker(s);
        sneakers.refreshCollections();
    }

    private String askName() {
        System.out.print("What is the name of the sneaker?");
        String name = input.next();
        return name;
    }

    private Double askPrice() {
        System.out.print("What is the price of the sneaker?");
        Double price = input.nextDouble();
        return price;
    }

    private Double askSize() {
        System.out.print("What is the size of the sneaker?");
        Double size = input.nextDouble();
        return size;
    }

    private String askColorWay() {
        System.out.print("What is the colorway of the sneaker?");
        String colorway = input.next();
        return colorway;
    }

    private Boolean askOwn() {
        System.out.print("Do you have the sneaker? yes or no!");
        if (input.next() == "yes") {
            return true;
        } else {
            return false;
        }
    }

    private void doViewWants() {
        System.out.println(sneakers.getSneakerWantList());
    }


}
