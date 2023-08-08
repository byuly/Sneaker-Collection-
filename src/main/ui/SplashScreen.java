package ui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

// LEARNED FROM: roseindia.net/tutorial/java/swing/splashScreen/html
public class SplashScreen {

    public SplashScreen() {
        Image image = Toolkit.getDefaultToolkit().getImage("data/_.jpeg");
        JWindow window = new JWindow();
        JLabel picLabel = new JLabel(new ImageIcon(image));
        window.setContentPane(picLabel);
        window.setBounds(500,500,500,500);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        window.setVisible(false);
        window.dispose();


    }
}
