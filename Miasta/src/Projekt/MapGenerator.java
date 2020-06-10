package Projekt;

import java.util.ArrayList;
import java.util.List;

public class MapGenerator {

    List<List<Field>> map = new ArrayList<List<Field>>(); //dwuwymiarowa lista przechowująca obiekty pól

    protected MapGenerator(int map_size, RandomNumber randomNumber) {


        for (int i = 0; i < map_size; i++) {
            map.add(new ArrayList<>());
        }
        for (int i = 0; i < map_size; i++) {
            for (int j = 0; j < map_size; j++) {
                switch (randomNumber.getRandomNumber(4)) {

                    case 0:
                        map.get(i).add(j, new Forest());
                        break;

                    case 1:
                        map.get(i).add(j, new Mountain());
                        break;

                    case 2:
                        map.get(i).add(j, new Sand());
                        break;

                    case 3:
                        map.get(i).add(j, new Lake());
                        break;

                }
            }
        }

    }

    public List<List<Field>> viewMap() {
        return map;
    }

    protected int getOwnership(int x, int y) {
        return map.get(x).get(y).getOwnership();
    }

    protected void setOwnership(int x, int y, int own) {
        map.get(x).get(y).setOwnership(own);
    }

    protected void map_viewer(int map_size) //wersja deweloperska do sprawdzania mapy, potem się to wywali
    {
        for (int i = 0; i < map_size; i++) {
            for (int j = 0; j < map_size; j++) {
                System.out.print(map.get(i).get(j).getOwnership() + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    protected void value_viewer(int map_size) //wersja deweloperska do sprawdzania mapy, potem się to wywali
    {
        for (int i = 0; i < map_size; i++) {
            for (int j = 0; j < map_size; j++) {
                System.out.print(map.get(i).get(j).getValue() + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    protected int getValue(int x, int y) {
        return map.get(x).get(y).getValue();
    }
}




