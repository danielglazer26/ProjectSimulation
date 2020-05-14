package PoleTekstowe;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Mapa extends JPanel {

    int rozmiar_mapy;

    public Mapa(int rozmiar_mapy) {
        setMaximumSize(new Dimension(rozmiar_mapy * 50, rozmiar_mapy * 50));
        this.rozmiar_mapy = rozmiar_mapy;

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

       for (int i = 0; i <= rozmiar_mapy; i++) {
            for (int j = 0; j <= rozmiar_mapy; j++) {
                if (i != rozmiar_mapy && j != rozmiar_mapy) {

                    Random random = new Random();
                    switch (random.nextInt(4)) {

                        case 3:
                            g2d.setPaint(Color.gray);
                            g2d.fillRect(10 + i * 50, 10 + j * 50, 50, 50);
                            g2d.setPaint(Color.BLACK);
                            g2d.draw(MapElements.getMountain(10 + i * 50, 10 + j * 50));
                            break;
                        case 2:
                            if (random.nextBoolean()) {
                                g2d.setPaint(new Color(36, 172, 172));
                                g2d.fillRect(10 + i * 50, 10 + j * 50, 50, 50);
                                g2d.drawImage(MapElements.getImage("2.png"), 10 + i * 50, 10 + j * 50, this);
                            } else {
                                g2d.setPaint(Color.BLUE);
                                g2d.fillRect(10 + i * 50, 10 + j * 50, 50, 50);
                            }
                            break;
                        case 1:
                            g2d.setPaint(Color.yellow);
                            g2d.fillRect(10 + i * 50, 10 + j * 50, 50, 50);
                            g2d.drawImage(MapElements.getImage("455.png"), 10 + i * 50, 10 + j * 50, this);
                            break;
                        case 0:
                            g2d.setPaint(new Color(13, 108, 13));
                            g2d.fillRect(10 + i * 50, 10 + j * 50, 50, 50);
                            g2d.setPaint(Color.BLACK);
                            g2d.draw(MapElements.getTree(10 + i * 50, 10 + j * 50));
                            break;
                    }
                }

                g2d.setPaint(Color.BLACK);


                /*g2d.drawLine(30, 55, 40, 55);
                g2d.drawLine(30, 45, 30, 55);
                g2d.drawLine(40, 45, 40, 55);
                g2d.drawLine(20, 45, 50, 45);
                g2d.drawLine(20, 45, 30, 35);
                g2d.drawLine(50, 45, 40, 35);
                g2d.drawLine(20, 35, 30, 35);
                g2d.drawLine(50, 35, 40, 35);
                g2d.drawLine(20, 35, 30, 25);
                g2d.drawLine(50, 35, 40, 25);
                g2d.drawLine(25, 25, 30, 25);
                g2d.drawLine(45, 25, 40, 25);
                g2d.drawLine(25, 25, 35, 15);
                g2d.drawLine(45, 25, 35, 15);*/
                if (i != rozmiar_mapy)
                    g2d.drawLine(10 + i * 50, 10 + j * 50, 10 + (i + 1) * 50, 10 + j * 50);
                if (j != rozmiar_mapy)
                    g2d.drawLine(10 + i * 50, 10 + j * 50, 10 + i * 50, 10 + (j + 1) * 50);
                /*g2d.drawString("Miasto", 18, 37);*/
            }
        }
    }
}

