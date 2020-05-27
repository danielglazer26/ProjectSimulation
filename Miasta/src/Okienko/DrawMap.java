package Okienko;

import Projekt.City;
import Projekt.Field;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.AttributedCharacterIterator;
import java.util.ArrayList;
import java.util.List;

import static Okienko.MapElements.getMountain;


public class DrawMap extends JPanel { //Klasa od rysowania, bałagan jak chuj ale na razie mam dość tej klasy
    //Można ją później połączyć jakoś z MapGeneratorem

    private final int map_size;
    private final ArrayList<City> cities;
    private final List<List<Field>> lists;

    public DrawMap(int map_size, List<List<Field>> lists, ArrayList<City> cities) {
        this.map_size = map_size;
        this.lists = lists;
        this.cities = cities;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        System.out.println("Kurwa dzialaj"); // To już wyznacznik tego jak bardzo uwielbiam tą klasę
        drawMap(map_size, lists, cities, g2d);
        drawLegend(map_size, cities, g2d);
    }

    private void drawLegend(int map_size, ArrayList<City> cities, Graphics2D g2d) {

        g2d.drawString("Obecna tura: "+ MapWindow.getCurrent_Turn(), (map_size + 1) * 50, 50);

        for (int i = 0; i < cities.size(); i++) {

            g2d.setColor(cities.get(i).getColor());
            g2d.drawString("Miasto", (map_size + 1) * 50, 100 + i * 50);
            g2d.drawString("Poziom miasta: " + cities.get(i).getFields_number(), (map_size + 1) * 50, 110 + i * 50);
            g2d.drawString("Wartość miasta: " + cities.get(i).getFortune(), (map_size + 1) * 50, 120 + i * 50);
        }
    }

    private void drawMap(int map_size, List<List<Field>> lists, ArrayList<City> cities, Graphics2D g2d) {

        for (int i = 0; i <= map_size; i++) {
            for (int j = 0; j <= map_size; j++) {
                if (i != map_size && j != map_size) {
                    if (isCapital(g2d, i, j)) {
                        if (isCityArea(g2d, i, j)) {
                            switch (lists.get(j).get(i).getValue()) { // Jak potrafisz zmienic ze sprawdza jakiego typu jest Klasa w tablicy to mozesz to zamienic
                                case 15:
                                    g2d.setPaint(Color.gray);
                                    g2d.fillRect(10 + i * 50, 10 + j * 50, 50, 50);
                                    g2d.setPaint(Color.BLACK);
                                    g2d.draw(getMountain(10 + i * 50, 10 + j * 50));
                                    break;
                                case -1:
                                    g2d.setPaint(Color.BLUE);
                                    g2d.fillRect(10 + i * 50, 10 + j * 50, 50, 50);
                                    break;
                                case 5:
                                    g2d.setPaint(Color.yellow);
                                    g2d.fillRect(10 + i * 50, 10 + j * 50, 50, 50);
                                    g2d.drawImage(MapElements.getImage("sand.png"), 10 + i * 50, 10 + j * 50, this);
                                    break;
                                case 10:
                                    g2d.setPaint(new Color(13, 108, 13));
                                    g2d.fillRect(10 + i * 50, 10 + j * 50, 50, 50);
                                    g2d.setPaint(Color.BLACK);
                                    g2d.draw(MapElements.getTree(10 + i * 50, 10 + j * 50));
                                    break;
                            }
                        }
                    }
                }
                g2d.setPaint(Color.BLACK);

                if (i != map_size)
                    g2d.drawLine(10 + i * 50, 10 + j * 50, 10 + (i + 1) * 50, 10 + j * 50);
                if (j != map_size)
                    g2d.drawLine(10 + i * 50, 10 + j * 50, 10 + i * 50, 10 + (j + 1) * 50);

            }

        }
    }

    private Boolean isCapital(Graphics2D g2d, int i, int j) {
        for (City city : cities) {
            if (i == city.getY() && j == city.getX()) {
                g2d.setPaint(city.getColor());
                g2d.fillRect(10 + i * 50, 10 + j * 50, 50, 50);
                g2d.drawImage(MapElements.getImage("city_icon.png"), 10 + i * 50, 10 + j * 50, this);
                return false;
            }
        }
        return true;

    }

    private Boolean isCityArea(Graphics2D g2d, int i, int j) {
        if (lists.get(j).get(i).getOwnership() != 0) {
            g2d.setPaint(cities.get(lists.get(j).get(i).getOwnership() - 1).getColor());
            g2d.fillRect(10 + i * 50, 10 + j * 50, 50, 50);
            switch (lists.get(j).get(i).getValue()) {
                case 15:
                    g2d.setPaint(Color.BLACK);
                    g2d.draw(getMountain(10 + i * 50, 10 + j * 50));
                    break;
                case 5:
                    g2d.drawImage(MapElements.getImage("sand.png"), 10 + i * 50, 10 + j * 50, this);
                    break;
                case 10:
                    g2d.setPaint(Color.BLACK);
                    g2d.draw(MapElements.getTree(10 + i * 50, 10 + j * 50));
                    break;
            }
            return false;
        }
        return true;
    }

}

