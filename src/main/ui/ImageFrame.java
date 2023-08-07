package ui;

import javax.imageio.ImageIO;
import javax.swing.*;

public class ImageFrame extends JFrame {
    private JLabel displayField;
    ImageIcon image;

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
