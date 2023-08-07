package ui;

import model.Sneaker;
import model.SneakerList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddSneakerFrame extends JFrame {
    private JTextField nameField;
    private JTextField colorField;
    private JTextField ownedField;
    private JTextField sizeField;
    private JTextField priceField;

    public AddSneakerFrame(SneakerList ss) {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(new GridLayout(0, 2));
        addNameButton();
        addColorButton();
        addOwnedButton();
        addSizeButton();
        addPriceButton();
        goBackButton();
        addSneakerButton(ss);
        this.pack();
        setLocationRelativeTo(null);
        this.setVisible(true);
    }

    // EFFECTS: sets up the name on the sneaker when button is pressed.
    private void addNameButton() {
        JButton nameButton = new JButton("NAME ->");
        nameField = new JTextField();
        nameField.setPreferredSize(new Dimension(250,30));
        nameField.setText("ex: Nike Jordan 1's");
        add(nameButton);
        add(nameField);
    }

    // EFFECTS: sets up the color on the sneaker when button is pressed.
    private void addColorButton() {
        JButton ownButton = new JButton("COLOR ->");
        colorField = new JTextField();
        colorField.setPreferredSize(new Dimension(250,30));
        colorField.setText("ex: White");
        add(ownButton);
        add(colorField);
    }

    // EFFECTS: sets up the price on the sneaker when button is pressed.
    private void addPriceButton() {
        JButton ownButton = new JButton("PRICE ->");
        priceField = new JTextField();
        priceField.setPreferredSize(new Dimension(250,30));
        priceField.setText("ex: 90.0, 149.99, etc.");
        add(ownButton);
        add(priceField);
    }

    // EFFECTS: sets up the size on the sneaker when button is pressed.
    private void addSizeButton() {
        JButton ownButton = new JButton("SIZE ->");
        sizeField = new JTextField();
        sizeField.setPreferredSize(new Dimension(250,30));
        sizeField.setText("ex: 7.0, 9.5, etc.");
        add(ownButton);
        add(sizeField);
    }

    // EFFECTS: sets up the owned status on the sneaker when button is pressed.
    private void addOwnedButton() {
        JButton ownButton = new JButton("Do you have the sneaker? yes or no! ->");
        ownedField = new JTextField();
        ownedField.setPreferredSize(new Dimension(250,30));
        ownedField.setText("ex: \"yes\" or \"no\"");
        add(ownButton);
        add(ownedField);
    }

    // EFFECTS: adds sneaker when button is pressed.
    private void addSneakerButton(SneakerList ss) {
        JButton sneakerButton = new JButton("ADD SNEAKER");
        sneakerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(null,
                        "Did you fill all the required information?", "ADD SNEAKER",
                        JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    Double price = Double.parseDouble(priceField.getText());
                    Double size = Double.parseDouble(sizeField.getText());
                    Sneaker s = new Sneaker(price, size, nameField.getText(), colorField.getText());
                    if (ownedField.getText().equals("yes")) {
                        s.boughtWanted();
                    } else {
                        s.soldOwned();
                    }
                    ss.addSneaker(s);
                    successfulMessage();
                    dispose();
                }
            }
        });
        add(sneakerButton);
    }

    // MODIFIES: this
    // EFFECTS: closes the editing tab
    private void goBackButton() {
        JButton goBackButton = new JButton("BACK TO MAIN MENU!");
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                dispose();


            }
        });
        add(goBackButton);
    }

    // EFFECTS: prints out message when editing a component is successful.
    private void successfulMessage() {
        JOptionPane.showMessageDialog(AddSneakerFrame.this,
                "Successfully Added!");
    }
}
