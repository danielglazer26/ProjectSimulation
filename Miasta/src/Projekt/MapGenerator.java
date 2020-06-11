package Projekt;

import java.util.ArrayList;
import java.util.List;

/**
 * Klasa odpowiedzialna za utworzenie mapy
 */
public class MapGenerator {

    /**dwuwymiarowa lista przechowujaca obiekty pol*/
    List<List<Field>> map = new ArrayList<List<Field>>();

    /**
     * Utworzenie mapy
     * @param map_size szerokosc mapy
     * @param randomNumber liczby pseudolosowe
     */
    public MapGenerator(int map_size, RandomNumber randomNumber) {


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

    /**
     *
     * @return zwraca mape
     */
    public List<List<Field>> viewMap() {
        return map;
    }


    /**
     *
     * @param x wspolrzedna x
     * @param y wspolrzedna y
     * @return zwraca numer miasta posiadajacego pole
     */
    public int getOwnership(int x,int y){
        return map.get(x).get(y).getOwnership();
    }

    /**
     * Ustawia do ktorego miasta nalezy pole
     * @param x wspolrzedna x
     * @param y wspolrzedna y
     * @param own numer miasta
     */
    public void setOwnership(int x, int y, int own){
        map.get(x).get(y).setOwnership(own);
    }

    /**
     * Sprawdzanie mapy w konsoli (testy)
     * @param map_size szerokosc mapy
     */
    public void map_viewer(int map_size) //wersja deweloperska do sprawdzania mapy
    {
        for (int i = 0; i < map_size; i++) {
            for (int j = 0; j < map_size; j++) {
                System.out.print(map.get(i).get(j).getOwnership() + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     *
     * @param x wspolrzedna x
     * @param y wspolrzedna y
     * @return zwraca wartosc pola
     */
    public int getValue(int x, int y){
        return map.get(x).get(y).getValue();
    }

    public void setValue(int x, int y, int value){map.get(x).get(y).setValue(value);}
}




