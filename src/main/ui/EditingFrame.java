package ui;

import model.Sneaker;

import javax.swing.*;
import java.awt.*;

public class EditingFrame extends JFrame {
    private JButton nameButton;
    private JTextField nameField;

    private Sneaker editing;

    public EditingFrame(Sneaker editing) {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(new FlowLayout());

        nameButton = new JButton("CHANGE NAME TO ->");
        nameField = new JTextField();
        nameField.setPreferredSize(new Dimension(250,30));
        nameField.setText(editing.getName());


        this.add(nameButton);
        this.add(nameField);
        this.pack();
        this.setVisible(true);
    }
}
