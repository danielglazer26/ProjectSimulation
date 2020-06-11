package Okienko;

import Projekt.City;
import Projekt.Field;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static Okienko.MapElements.getMountain;

/**
 * Klasa od rysowania mapy
 */
public class DrawMap extends JPanel {

    private final int map_size;
    private final int window_resizable;
    private final ArrayList<City> cities;
    private final List<List<Field>> lists;

    /**
     * Przypisuje wartosci do zmiennych prywatnych
     * @param map_size rozmiar mapy
     * @param window_resizable wspolczynnik skalowania okna
     * @param lists lista mapa
     * @param cities Arraylista miast
     */
    public DrawMap(int map_size, int window_resizable, List<List<Field>> lists, ArrayList<City> cities) {
        this.map_size = map_size;
        this.lists = lists;
        this.cities = cities;
        this.window_resizable = window_resizable;
    }

    /**
     * Wywoluje metody od rysowania mapy i legendy
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        //g.setFont(g.getFont().deriveFont(g.getFont().getSize() * ((50F / window_resizable))));
        g2d.scale(((float) (window_resizable)) / 50, ((float) (window_resizable)) / 50);
        drawMap(g2d);
        drawLegend(g2d);
    }

    /**
     * Rysowanie legendy
     */
    private void drawLegend(Graphics2D g2d) {

        g2d.drawString("Obecna tura: " + MapWindow.getCurrent_Turn(), (map_size + 1) * 50, 25);

        for (int i = 0; i < cities.size(); i++) {

            g2d.setColor(cities.get(i).getColor());
            if (cities.get(i).getCity_level() == 0) {
                g2d.drawString("Miasto", (map_size + 1) * 50, 35 +  i * 50);
                g2d.drawString("Upadek", (map_size + 1) * 50, 45 +  i * 50);
            } else {
                g2d.drawString("Miasto", (map_size + 1) * 50, 35 + + i * 50);
                g2d.drawString("Poziom miasta: " + cities.get(i).getCity_level(), (map_size + 1) * 50, 45   + i * 50);
                g2d.drawString("Wartość miasta: " + cities.get(i).getFortune(), (map_size + 1) * 50, 55  + i * 50);
            }

        }
    }

    /**
     * Rysowanie mapy
     */
    private void drawMap(Graphics2D g2d) {

        for (int i = 0; i <= map_size; i++) {
            for (int j = 0; j <= map_size; j++) {
                if (i != map_size && j != map_size) {
                    if (isCapital(g2d, i, j)) {
                        if (isCityArea(g2d, i, j)) {
                            switch (lists.get(j).get(i).getValue()) {
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

    /**
     *Sprawdza czy na danych wspolrzednych znajduje sie stolica, jesli tak to rysuje w tym miejscu miasto
     * @param i wspolrzedna y
     * @param j wspolrzedna x
     * @return prawda jesli nie jest stolica/ falsz jesli jest stolica
     */
    private Boolean isCapital(Graphics2D g2d, int i, int j) {
        for (City city : cities) {
            if (city.getCity_level() != 0) {
                if (i == city.getY() && j == city.getX()) {
                    g2d.setPaint(city.getColor());
                    g2d.fillRect(10 + i * 50, 10 + j * 50, 50, 50);
                    g2d.drawImage(MapElements.getImage("city_icon.png"), 10 + i * 50, 10 + j * 50, this);
                    return false;
                }
            }
        }
        return true;

    }

    /**
     * Sprawdza czy na danych wspolrzednych znajduje sie teren miasta, jesli tak barwi teren na kolor miasta
     * @param i wspolrzedna y
     * @param j wspolrzedna x
     * @return prawda jesli nie jest terenem miasta/ falsz jesli jest terenem miasta
     */
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

