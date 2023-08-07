package ui;

import model.Sneaker;
import model.SneakerList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditingFrame extends JFrame {

    private JTextField nameField;
    private JTextField ownedField;
    private Sneaker editing;
    private SneakerList sneakersButton;

    public EditingFrame(Sneaker editing, SneakerList sneakersButton) {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(new GridLayout(0, 2));
        editNameButton(editing);
        editOwnedButton(editing, sneakersButton);
        editColorButton(editing);
        editSizeButton(editing);
        editPriceButton(editing);
        removeSneakerButton(editing, sneakersButton);
        this.pack();
        setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void removeSneakerButton(Sneaker s,SneakerList sb) {
        JButton removeButton = new JButton("REMOVE SNEAKER");
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(null,
                        "Do you want to remove this sneaker??", "REMOVE SNEAKER",
                        JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    sb.removeSneaker(s);
                    dispose();
                } else if (result == JOptionPane.NO_OPTION) {
                    JOptionPane.showMessageDialog(EditingFrame.this, "Going Back to Main Menu!");
                }
            }
        });
        add(removeButton);
    }

    private void editNameButton(Sneaker s) {
        JButton nameButton = new JButton("CHANGE NAME TO ->");
        nameField = new JTextField();
        nameField.setPreferredSize(new Dimension(250,30));
        nameField.setText(s.getName());
        nameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                s.setName(nameField.getText());
                successfulMessage();
            }
        });
        add(nameButton);
        add(nameField);
    }

    private void editColorButton(Sneaker s) {
        JButton colorButton = new JButton("CHANGE COLORWAY TO ->");
        JTextField colorField = new JTextField();
        colorField.setPreferredSize(new Dimension(250,30));
        colorField.setText(s.getColorway());
        colorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                s.setColorway(colorField.getText());
                successfulMessage();
            }
        });
        add(colorButton);
        add(colorField);
    }

    private void editSizeButton(Sneaker s) {
        JButton sizeButton = new JButton("CHANGE SIZE TO ->");
        JTextField sizeField = new JTextField();
        sizeField.setPreferredSize(new Dimension(250,30));
        sizeField.setText(String.valueOf(s.getSize()));
        sizeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                s.setSize(Double.parseDouble(sizeField.getText()));
                successfulMessage();
            }
        });
        add(sizeButton);
        add(sizeField);
    }

    private void editPriceButton(Sneaker s) {
        JButton priceButton = new JButton("CHANGE PRICE TO ->");
        JTextField priceField = new JTextField();
        priceField.setPreferredSize(new Dimension(250,30));
        priceField.setText(String.valueOf(s.getPrice()));
        priceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                s.setPrice(Double.parseDouble(priceField.getText()));
                successfulMessage();
            }
        });
        add(priceButton);
        add(priceField);
    }

    private void editOwnedButton(Sneaker s, SneakerList sb) {
        JButton ownedButton = new JButton("CHANGE OWNED STATUS TO ->");
        ownedField = new JTextField();
        ownedField.setPreferredSize(new Dimension(250,30));
        setBoughtText(s);
        ownedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String answer = ownedField.getText();
                if (answer.equals("owned")) {
                    s.boughtWanted();
                    sb.refreshCollections();
                    successfulMessage();
                } else if (answer.equals("wanted")) {
                    s.soldOwned();
                    sb.refreshCollections();
                    successfulMessage();
                } else {
                    JOptionPane.showMessageDialog(EditingFrame.this,
                            "Selection not valid! Status remains the same.");
                }
            }
        });
        add(ownedButton);
        add(ownedField);
    }

    private void setBoughtText(Sneaker s) {
        if (s.isBoughtYet()) {
            ownedField.setText("owned");
        } else {
            ownedField.setText("wanted");
        }
    }

    private void successfulMessage() {
        JOptionPane.showMessageDialog(EditingFrame.this,
                "Successfully Edited!");
    }
}
