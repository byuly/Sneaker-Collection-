package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.IOException;

import model.Event;
import model.EventLog;
import model.SneakerList;
import persistence.JsonReader;
import persistence.JsonWriter;

// class represents the graphical user interface.
// CITATION: https://www.edureka.co/community/67239/how-to-add-action-listener-that-listens-to-multiple-buttons
public class Gui extends JFrame {
    private static final String JSON_STORE = "./data/collection.json";
    protected SneakerList sneakersGui;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    // EFFECTS: constructs gui with title.
    public Gui() throws FileNotFoundException {
        super("Sneaker Collection");
        sneakersGui = new SneakerList();
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);

        setGUI();
    }

    // MODIFIES: this
    // EFFECTS: sets up the gui with the buttons.
    private void setGUI() {

        setLayout(new GridLayout(0,2));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // buttons for each option
        saveSneakerButton();
        loadSneakerButton();
        viewWantedSneakersButton();
        viewOwnedSneakersButton();
        searchSneakerButton();
        viewSneakersButton();
        clearSneakerCollectionButton();
        addSneakerButton();
        addImageButton();
        // CITATION:
        // https://examples.javacodegeeks.com/java-development/desktop-java/awt/event/window-closing-event-handling/
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                for (Event next : EventLog.getInstance()) {
                    System.out.println("-" + next.toString());
                }
            }
        });
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // EFFECTS: When button is pressed, a new Frame appears to image.
    private void addImageButton() {
        JButton imageButton = new JButton(":)");
        imageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ImageFrame();
            }
        });
        add(imageButton);
    }

    // EFFECTS: When button is pressed, a new Frame appears to add sneaker.
    private void addSneakerButton() {
        JButton addButton = new JButton("Add Sneaker");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddSneakerFrame(sneakersGui);
            }
        });
        add(addButton);
    }

    // EFFECTS: presents search bar and new panel when button is pressed.
    @SuppressWarnings("methodlength")
    private void searchSneakerButton() {
        JTextField sneakerSearch = new JTextField(10);
        JButton searchButton = new JButton("search ->");
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = sneakerSearch.getText();
                if (0 == sneakersGui.getSneakerSearch(name).size()) {
                    JOptionPane.showMessageDialog(Gui.this, "invalid search!");
                } else {
                    JOptionPane.showMessageDialog(Gui.this, sneakersGui.getSneakerSearch(name));
                }
                if (1 != sneakersGui.getSneakerSearch(name).size()) {
                    JOptionPane.showMessageDialog(Gui.this,
                            "To edit a sneaker, specify search to one sneaker!");
                } else if (1 == sneakersGui.getSneakerSearch(name).size()) {
                    int result = JOptionPane.showConfirmDialog(null,
                            "Do you want to edit this sneaker??", "EDIT SNEAKER",
                            JOptionPane.YES_NO_OPTION);
                    if (result == JOptionPane.YES_OPTION) {
                        new EditingFrame(sneakersGui.getOneSneaker(sneakersGui.getSneakerSearch(name)), sneakersGui);
                        sneakersGui.refreshCollections();
                    } else if (result == JOptionPane.NO_OPTION) {
                        JOptionPane.showMessageDialog(Gui.this, "Going Back to Main Menu!");
                    }
                }
            }
        });

        add(searchButton);
        add(sneakerSearch);
    }


    // EFFECTS: saves the collection of sneakers when button is pressed.
    private void saveSneakerButton() {
        JButton saveButton = new JButton("Save Collection");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveSneakers();
                JOptionPane.showMessageDialog(Gui.this, "Successfully saved!");
            }
        });
        add(saveButton);
    }

    // EFFECTS: loads the previous saved collection of sneakers when button is pressed.
    private void loadSneakerButton() {
        JButton loadButton = new JButton("Load Saved Collection");
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadSneakers();
                JOptionPane.showMessageDialog(Gui.this, "Successfully Loaded!");
            }

        });
        add(loadButton);
    }

    // EFFECTS: shows list of ALL sneakers when button is pressed.
    private void viewSneakersButton() {
        JButton viewAllButton = new JButton("View All Sneakers");
        viewAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(Gui.this, sneakersGui.getSneakerList());
            }

        });
        add(viewAllButton);
    }

    // EFFECTS: shows list of OWNED sneakers when button is pressed.
    private void viewOwnedSneakersButton() {
        JButton viewOwnedButton = new JButton("View List of Owned Sneakers");
        viewOwnedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(Gui.this, sneakersGui.getSneakerOwnList());
            }

        });
        add(viewOwnedButton);
    }

    // EFFECTS: shows list of WANTED sneakers when button is pressed.
    private void viewWantedSneakersButton() {
        JButton viewWantsButton = new JButton("View List of Wanted Sneakers");
        viewWantsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(Gui.this, sneakersGui.getSneakerWantList());
            }

        });
        add(viewWantsButton);

    }

    // CITATION: YOUTUBE TUTORIAL: youtube.com/watch?v=TFBRilCqLeg&ab_channel=MaxO%27Didily.
    // EFFECTS: clears the collection list when button is pressed.
    private void clearSneakerCollectionButton() {
        JButton clearButton = new JButton("Clear All Lists");
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(null,
                        "Are you sure you want to clear all lists?", "Confirmation",
                        JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {

                    sneakersGui.clearSneakerList();
                }
            }

        });
        add(clearButton);
    }





    // CONSTRUCTED FROM:
    // https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo/blob/master/src/main/ui/WorkRoomApp.java
    // EFFECTS: saves the workroom to file
    private void saveSneakers() {
        try {
            jsonWriter.open();
            jsonWriter.write(sneakersGui);
            jsonWriter.close();
            System.out.println("Saved " + "collection" + " to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // CONSTRUCTED FROM:
    // https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo/blob/master/src/main/ui/WorkRoomApp.java
    // MODIFIES: this
    // EFFECTS: loads workroom from file

    private void loadSneakers() {
        try {
            sneakersGui = jsonReader.read();
            System.out.println("Loaded " + "collection" + " from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }
}

