package Misc;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel {
    private HashMap<String,Point> points = new HashMap<>();
    private HashMap<String,BufferedImage> pics = new HashMap<>();

    void init(String name) {
        points.put(name, new Point());
        // Print an error message in case file is not found with a try/catch block
        try {
            BufferedImage image = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/" + name + ".jpg"));
            pics.put(name, image);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    void moveit(String name, int x, int y) {
        points.get(name).x = x;
        points.get(name).y = y;
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (HashMap.Entry<String,Point> mapElement : points.entrySet()) {
            int x = mapElement.getValue().x;
            int y = mapElement.getValue().y;
            BufferedImage image = pics.get(mapElement.getKey());
            g.drawImage(image, x, y, null); // see javadoc for more info on the parameters
        }
    }
}
