package ui;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
// https://www.guru99.com/java-swing-gui.html

// Main class for running application.
public class Main {
    public static void main(String[] args) {
        try {
            new Gui();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}