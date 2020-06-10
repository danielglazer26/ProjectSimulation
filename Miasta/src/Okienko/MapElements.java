package Okienko;

import javax.imageio.ImageIO;
import java.awt.geom.GeneralPath;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

abstract class MapElements {


    public static GeneralPath getTree(int x, int y) {
        GeneralPath tree = new GeneralPath();
        tree.moveTo(x + 20, y + 45);
        tree.lineTo(x + 30, y + 45);
        tree.lineTo(x + 30, y + 35);
        tree.lineTo(x + 40, y + 35);
        tree.lineTo(x + 30, y + 25);
        tree.lineTo(x + 40, y + 25);
        tree.lineTo(x + 30, y + 15);
        tree.lineTo(x + 35, y + 15);
        tree.lineTo(x + 25, y + 5);
        tree.lineTo(x + 15, y + 15);
        tree.lineTo(x + 20, y + 15);
        tree.lineTo(x + 10, y + 25);
        tree.lineTo(x + 20, y + 25);
        tree.lineTo(x + 10, y + 35);
        tree.lineTo(x + 20, y + 35);
        tree.closePath();
        return tree;
    }

    public static GeneralPath getMountain(int x, int y) {
        GeneralPath mountain = new GeneralPath();

        mountain.moveTo(x + 2, y + 42);
        mountain.lineTo(x + 12, y + 12);
        mountain.lineTo(x + 19, y + 27);
        mountain.moveTo(x + 13, y + 42);
        mountain.lineTo(x + 21, y + 23);
        mountain.lineTo(x + 31, y + 42);
        mountain.moveTo(x + 46, y + 42);
        mountain.lineTo(x + 32, y + 7);
        mountain.lineTo(x + 24, y + 28);

        return mountain;
    }

    public static BufferedImage getImage(String nazwa) {

        BufferedImage image = null;

        File imageFile = new File(nazwa);
        try {
            image = ImageIO.read(imageFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }

}
