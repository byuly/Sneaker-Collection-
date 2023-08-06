package ui;

import javax.swing.*;
import java.awt.*;

public class NewWindow extends JFrame {

    JFrame frame = new JFrame();
    JLabel label = new JLabel("Hello");

    public NewWindow() {
        JTextField textField = new JTextField();

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
