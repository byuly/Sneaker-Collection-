package ui;

import model.Sneaker;
import model.SneakerList;
import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Scanner;

// The following code is inspired from the TellerApp class in the TellerApp project:
// https://github.students.cs.ubc.ca/CPSC210/TellerApp/blob/main/src/main/ca/ubc/cpsc210/bank/ui/TellerApp.java
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
        } else if (command.equals("o")) {
            doViewOwned();
        } else if (command.equals("a")) {
            doViewAll();
        } else if (command.equals("search")) {
            doSearch();
        } else {
            System.out.println("Selection not valid...");
        }
    }

    // EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\ts -> add sneaker");
        System.out.println("\tw -> view list of wanted sneakers");
        System.out.println("\to -> view list of owned sneakers");
        System.out.println("\ta -> view all sneakers");
        System.out.println("\tsearch -> search for sneakers");
    }

    // MODIFIES: this
    // EFFECTS: adds sneaker
    private void doAddSneaker() {
        String name = askName();
        Double price = askPrice();
        Double size = askSize();
        String colorway = askColorWay();

        Sneaker s = new Sneaker(price, size, name, colorway);
        askOwn(s);
        sneakers.addSneaker(s);
    }

    // EFFECTS: returns the String input of the user.
    private String askName() {
        System.out.print("What is the name of the sneaker?");
        String name = input.next();
        return name;
    }

    // EFFECTS: returns Double input of the user.
    private Double askPrice() {
        System.out.print("What is the price of the sneaker?");
        Double price = input.nextDouble();
        return price;
    }

    // EFFECTS: returns Double input of the user.
    private Double askSize() {
        System.out.print("What is the size of the sneaker?");
        Double size = input.nextDouble();
        return size;
    }

    // EFFECTS: returns String input of the user.
    private String askColorWay() {
        System.out.print("What is the colorway of the sneaker?");
        String colorway = input.next();
        return colorway;
    }

    // EFFECTS: gets String input from user, and returns Boolean.
    private void askOwn(Sneaker s) {
        System.out.print("Do you have the sneaker? yes or no!");
        if (input.next().equals("yes")) {
            s.boughtWanted();
        } else {
            s.soldOwned();
        }
    }

    // EFFECTS: prints the wanted sneakers list to the user.
    private void doViewWants() {
        System.out.println(sneakers.getSneakerWantList());
    }


    // EFFECTS: prints the owned sneakers list to the user.
    private void doViewOwned() {
        System.out.println(sneakers.getSneakerOwnList());
    }

    // EFFECTS: prints the all sneakers list to the user.
    private void doViewAll() {
        System.out.println(sneakers.getSneakerList());
    }

    private void doSearch() {
        System.out.println("search bar:");
        String answer = input.next();
        if (0 == sneakers.getSneakerSearch(answer).size()) {
            System.out.println("invalid search!");
        } else {
            System.out.println(sneakers.getSneakerSearch(answer));
        }
        if (1 == sneakers.getSneakerSearch(answer).size()) {
            editSneaker(sneakers.getSneakerSearch(answer));
        } else {
            System.out.println("To edit a sneaker, specify search to one sneaker!");
        }
    }

    // EFFECTS: display menu for editing sneaker.
    private void editSneaker(ArrayList<String> editing) {
        System.out.println("\nSelect from:");
        System.out.println("\tn -> edit name");
        System.out.println("\to -> edit owned status");
        System.out.println("\tc -> edit color");
        System.out.println("\ts -> edit size");
        System.out.println("\tp -> edit price");
        System.out.println("\tr -> remove item");
        System.out.println("\tb -> back to menu");
        editSneakerCommands(editing);
    }

    // EFFECTS: execute user input for editing sneaker.
    private void editSneakerCommands(ArrayList<String> editing) {
        String answer = input.next();
        if (answer.equals("n")) {
            editName(editing);
        } else if (answer.equals("o")) {
            editOwned(editing);
        } else if (answer.equals("c")) {
            editColorway(editing);
        } else if (answer.equals("s")) {
            editSize(editing);
        } else if (answer.equals("p")) {
            editPrice(editing);
        } else if (answer.equals("r")) {
            editRemove(editing);
        } else if (answer.equals("b")) {
            System.out.println("going back!");
        } else {
            System.out.println("Selection not valid...");
        }
    }

    //EFFECTS: edits the name of sneaker searched.
    private void editName(ArrayList<String> editing) {
        Sneaker beingEdited = sneakers.getOneSneaker(editing);
        System.out.println("enter name -->");
        beingEdited.setName(input.next());
    }

    //EFFECTS: removes the sneaker searched.
    private void editRemove(ArrayList<String> editing) {
        Sneaker beingEdited = sneakers.getOneSneaker(editing);
        sneakers.removeSneaker(beingEdited);
        System.out.println("Successfully removed!");
    }

    //EFFECTS: edits the own status of sneaker searched.
    private void editOwned(ArrayList<String> editing) {
        Sneaker beingEdited = sneakers.getOneSneaker(editing);
        System.out.println("bought or sold? -->");
        String answer = input.next();
        if (answer.equals("bought")) {
            beingEdited.setOwned(true);
        } else if (answer.equals("sold")) {
            beingEdited.setOwned(false);
        } else {
            System.out.println("Selection not valid! Status remains the same.");
        }
    }

    //EFFECTS: edits the colorway of sneaker searched.
    private void editColorway(ArrayList<String> editing) {
        Sneaker beingEdited = sneakers.getOneSneaker(editing);
        System.out.println("enter colorway -->");
        beingEdited.setColorway(input.next());
    }

    //EFFECTS: edits the colorway of sneaker searched.
    private void editSize(ArrayList<String> editing) {
        Sneaker beingEdited = sneakers.getOneSneaker(editing);
        System.out.println("enter size -->");
        beingEdited.setSize(input.nextDouble());
    }

    //EFFECTS: edits the price of sneaker searched.
    private void editPrice(ArrayList<String> editing) {
        Sneaker beingEdited = sneakers.getOneSneaker(editing);
        System.out.println("enter size -->");
        beingEdited.setPrice(input.nextDouble());
    }






}
