package Projekt;

import java.awt.*;

/**
 * Klasa reprezentujaca miasta
 */
public class City {
    /**kolor miasta*/
    private final Color city_color;
    /**wartosc miasta*/
    private int fortune = 0;
    /**wspolrzedna x*/
    private int x;
    /**wspolrzedna y*/
    private int y;
    /**liczba posiadanych przez miasto pol*/
    private int fields_number;

    /**
     * Losowanie wspolrzednych poczatkowych miasta
     * @param map_size szerokosc mapy
     * @param randomNumber liczby pseudolosowe
     */
    protected City(int map_size, RandomNumber randomNumber) {

        x = randomNumber.getRandomNumber(map_size);
        y = randomNumber.getRandomNumber(map_size);
        city_color = new Color(randomNumber.getRandomNumber(256), randomNumber.getRandomNumber(256), randomNumber.getRandomNumber(256));

    }

    /**
     * Ponowne losowanie wspolrzednych miasta jesli pole bylo zajete
     * @param map_size szerokosc mapy
     * @param randomNumber liczby pseudolosowe
     */
    protected void localizationChange(int map_size, RandomNumber randomNumber) {
        x = randomNumber.getRandomNumber(map_size);
        y = randomNumber.getRandomNumber(map_size);
    }

    /**
     * Dodanie wartosci miasta
     * @param fortune wartosc miasta
     */
    protected void addFortune(int fortune) {
        this.fortune += fortune;
    }

    /**
     *
     * @return zwraca wartosc miasta
     */
    public int getFortune() {
        return fortune;
    }

    /**
     *
     * @return zwraca liczbe posiadanych przez miasto pol
     */
    public int getCity_level() {
        int city_level = this.fields_number;
        if (this.fields_number == 0)
            this.fortune = 0;
        return city_level;
    }

    /**
     *
     * @return zwraca wspolrzedna x
     */
    public int getX() {
        return x;
    }

    /**
     *
     * @return zwraca spolrzedna y
     */
    public int getY() {
        return y;
    }

    /**
     *
     * @return zwraca kolor miasta
     */
    public Color getColor() {
        return city_color;
    }

    /**
     *
     * @return zwraca liczbe posiadanych przez miasto pol
     */
    public int getFields_number(){return fields_number;}

    /**
     * Dodanie posiadanych pol
     */
    public void addFields_number(){this.fields_number++;}

    /**
     * Wyzerowanie posiadanych pol przed ponownym zliczeniem
     */
    public void setFields_number(){this.fields_number=0;}


}


