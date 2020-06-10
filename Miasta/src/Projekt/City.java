package Projekt;

import java.awt.*;

public class City {

    private final Color city_color;
    private int fortune = 0;
    private int x;
    private int y;  //dodałem x,y dla przejrzystości
    private int fields_number;

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
        int city_level = this.fields_number;
        if (this.fields_number == 0)
            this.fortune = 0;
        return city_level;
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

    public int getFields_number() {
        return fields_number;
    }

    public void addFields_number() {
        this.fields_number++;
    }

    public void setFields_number() {
        this.fields_number = 0;
    }


}


