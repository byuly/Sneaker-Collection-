package ui;

import javax.imageio.ImageIO;
import javax.swing.*;

// class represents a frame with a image.
// PICTURE FROM: https://www.pinterest.ca/pin/1126885137996999174/
public class ImageFrame extends JFrame {
    private JLabel displayField;
    private ImageIcon image;

    // EFFECTS: constructs frame with the given image.
    public ImageFrame() {
        this.setTitle(":)");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        try {
            image = new ImageIcon(("data/_.jpeg"));
            displayField = new JLabel(image);
            this.add(displayField);
        } catch (Exception e) {
            System.out.println("IMAGE CANNOT BE FOUND");
        }
        this.pack();
        setLocationRelativeTo(null);
        this.setVisible(true);
    }



}
