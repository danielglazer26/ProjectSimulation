package Projekt;

import java.util.ArrayList;

/**
 * Klasa odpowiada za ewolucje miast
 */
public class CitiesEvolution {

    /**lista miast*/
    private ArrayList<City> city_table = new ArrayList<>();
    /**obiekt odpowiadajacy za tworzenie mapy*/
    private MapGenerator mapGenerator;
    /**wspolrzedna x najlepszego pola*/
    private int best_x;
    /**wspolrzedna y najlepszego pola*/
    private int best_y;
    /**wartosc najlepszego pola*/
    private int best_value;
    /**true jesli algorytm wyboru pola wykonal sie w obecnej turze*/
    private boolean add;

    /**
     * Wywoluje mapGenerator, ktory tworzy mape a nastepnie
     * setLocalization ustala polozenie poczatkowe miast
     * @param map_size szerokosc mapy
     * @param number_cities liczba miast
     * @param randomNumber obiekt odpowiadajacy za liczby pseudolosowe
     */
    public CitiesEvolution(int map_size, int number_cities, RandomNumber randomNumber) {

        mapGenerator = new MapGenerator(map_size, randomNumber);

        CityLocalization.setLocalization(city_table, mapGenerator, number_cities, map_size, randomNumber);

        mapGenerator.map_viewer(map_size);


    }

    /**
     * Wybiera najlepsze pole (o najwiekszej wartosci), ktore jest wolne i obok posiadanego pola.
     * @param map_size szerokosc mapy
     * @param a numer miasta ktore jest sprawdzane
     */
    public void cityEvolution(int map_size, int a) {

        best_x = 0;
        best_y = 0;
        best_value = 0;
        add = false;
        for (int i = 0; i < map_size; i++) {               //sprawdzanie dla kolejnych wspolrzednych mapy
            for (int j = 0; j < map_size; j++) {
                if (getMap().getOwnership(i,j)==a+1) {    //sprawdzenie czy pole nalezy do miasta
                    if (i > 0)
                        if (mapGenerator.getOwnership(i - 1, j)==0) {  //sprawdzenie czy pole jest wolne
                            if (mapGenerator.viewMap().get(i - 1).get(j).getValue() > best_value) {  //sprawdzenie czy obecne pole ma wieksza wartosc
                                best_x = i - 1;
                                best_y = j;
                                best_value = mapGenerator.viewMap().get(i - 1).get(j).getValue();
                                add = true;
                            }
                        }
                    //to samo ale dla innych wspolrzednych aby nie wyjsc poza mape
                    if (i < map_size - 1)
                        if (mapGenerator.getOwnership(i + 1, j) == 0) {
                            if (mapGenerator.viewMap().get(i + 1).get(j).getValue() > best_value) {
                                best_x = i + 1;
                                best_y = j;
                                best_value = mapGenerator.viewMap().get(i + 1).get(j).getValue();
                                add = true;
                            }

                        }
                    //to samo ale dla innych wspolrzednych aby nie wyjsc poza mape
                    if (j > 0)
                        if (mapGenerator.getOwnership(i, j - 1) == 0) {
                            if (mapGenerator.viewMap().get(i).get(j - 1).getValue() > best_value) {
                                best_x = i;
                                best_y = j - 1;
                                best_value = mapGenerator.viewMap().get(i).get(j - 1).getValue();
                                add = true;
                            }
                        }
                    //to samo ale dla innych wspolrzednych aby nie wyjsc poza mape
                    if (j < map_size - 1)
                        if (mapGenerator.getOwnership(i, j + 1) == 0) {
                            if (mapGenerator.viewMap().get(i).get(j + 1).getValue() > best_value) {
                                best_x = i;
                                best_y = j + 1;
                                best_value = mapGenerator.viewMap().get(i).get(j + 1).getValue();
                                add = true;
                            }
                        }
                }
            }
        }

    }

    /**
     * Sprawdza wartosc pola
     * @param x wspolrzedna x
     * @param y wspolrzedna y
     * @return wartosc sprawdzanego pola
     */
    public int checkField(int x, int y) {
        return mapGenerator.viewMap().get(x).get(y).getValue();
    }


    /**
     *
     * @return Zwraca wspolrzedna x
     */
    public int getBest_x1(){
        return best_x;
    }

    /**
     *
     * @return Zwraca wspolrzedna y
     */
    public int getBest_y1(){
        return best_y;
    }

    /**
     *
     * @return Zwraca true jesli algorytm wybral nowe najlepsze pole
     */
    public boolean getAdd1(){
        return add;
    }

    /**
     *
     * @return Zwraca obiekt przechowujacy mape
     */
    public MapGenerator getMap() {
        return mapGenerator;
    }

    /**
     *
     * @return Zwraca liste miast
     */
    public ArrayList<City> getCity_table() {
        return city_table;
    }

}
