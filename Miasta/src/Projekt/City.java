package Projekt;

import java.awt.*;

public class City {

    private int fortune = 0;
    private int city_level = 1;
    private int x;
    private int y;  //dodałem x,y dla przejrzystości
    private Color city_color;

    protected City(int map_size, RandomNumber randomNumber) {
        x = randomNumber.getRandomNumber(map_size);
        y = randomNumber.getRandomNumber(map_size);
        city_color = new Color(randomNumber.getRandomNumber(256), randomNumber.getRandomNumber(256), randomNumber.getRandomNumber(256));

    }

    protected void localizationChange(int map_size, RandomNumber randomNumber) {
        x = randomNumber.getRandomNumber(map_size);
        y = randomNumber.getRandomNumber(map_size);
    }


    protected void addFortune(int fortune) {
        this.fortune += fortune;
    }

    public int getFortune() {
        return fortune;
    }

    public int getCity_level() {
        return city_level;
    }

    protected void addLevel() {
        this.city_level += 1;
    }

    protected void decreaseLevel() {
        this.city_level -= 1;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public Color getColor() {
        return city_color;
    }


}


