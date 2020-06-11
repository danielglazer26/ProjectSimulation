package Projekt;


import java.util.ArrayList;

/**
 * Klasa odpowiadajaca za relacje miast
 *
 */
class CitiesRelation {

    /**numer tury od ktorej mozliwe jest zabieranie pol innym miastom*/
    private final float turn_late_number;
    /**wspolrzedna x najlepszego pola*/
    private int best_x;
    /**wspolrzedna y najlepszego pola*/
    private int best_y;
    /**wartosc najlepszego pola*/
    private int best_value;
    /**true jesli algorytm wyboru pola wykonal sie w obecnej turze*/
    private boolean add;



    /**
     * Oblicza numer tury od ktorej mozliwe jest zabieranie pol innym miastom
     * @param turn_number liczba wszystkich tur
     * @param agression_rate wspolczynnik agresji
     */
    public CitiesRelation(int turn_number, float agression_rate) {

        turn_late_number = turn_number * (1 - agression_rate);
    }

    /**
     * Szuka zajetych pol o najwiekszej wartosci graniczacych z terenami miasta
     * @param turn numer tury
     * @param map_size szerokosc mapy
     * @param number_cities liczba miast
     * @param current_city numer miasta
     * @param city_table lista miast
     * @param map mapa
     */
    protected void cityInfluence(int turn, int map_size, int number_cities, int current_city, ArrayList<City> city_table, MapGenerator map) {

        add = false;

        if (turn >= turn_late_number) {

            best_x = 0;
            best_y = 0;
            best_value = 0;


            for (int i = 0; i < map_size; i++) { //sprawdzanie dla kolejnych wspolrzednych mapy
                for (int j = 0; j < map_size; j++) {

                    if (map.getOwnership(i, j) == current_city + 1) { //sprawdzenie czy pole nalezy do miasta

                        if (i > 0)
                            //sprawdzenie czy pole jest zajete i nie nalezy do obecnego miasta
                            if (map.getOwnership(i - 1, j) > 0 && map.getOwnership(i - 1, j) != current_city + 1) {
                                //sprawdzenie czy obecne pole ma wieksza wartosc
                                if (map.viewMap().get(i - 1).get(j).getValue() > best_value) {
                                    if (cityCheck(current_city, number_cities, i - 1, j, city_table, map)) {
                                        best_x = i - 1;
                                        best_y = j;
                                        best_value = map.viewMap().get(i - 1).get(j).getValue();
                                        add = true;

                                    }
                                }
                            }
                        //to samo ale dla innych wspolrzednych aby nie wyjsc poza mape
                        if (i < map_size - 1)
                            if (map.getOwnership(i + 1, j) > 0 && map.getOwnership(i + 1, j) != current_city + 1) {
                                if (map.viewMap().get(i + 1).get(j).getValue() > best_value) {
                                    if (cityCheck(current_city, number_cities, i + 1, j, city_table, map)) {
                                        best_x = i + 1;
                                        best_y = j;
                                        best_value = map.viewMap().get(i + 1).get(j).getValue();
                                        add = true;

                                    }
                                }

                            }
                        //to samo ale dla innych wspolrzednych aby nie wyjsc poza mape
                        if (j > 0)
                            if (map.getOwnership(i, j - 1) > 0 && map.getOwnership(i, j - 1) != current_city + 1) {
                                if (map.viewMap().get(i).get(j - 1).getValue() > best_value) {
                                    if (cityCheck(current_city, number_cities, i, j - 1, city_table, map)) {
                                        best_x = i;
                                        best_y = j - 1;
                                        best_value = map.viewMap().get(i).get(j - 1).getValue();
                                        add = true;

                                    }
                                }
                            }
                        //to samo ale dla innych wspolrzednych aby nie wyjsc poza mape
                        if (j < map_size - 1)
                            if (map.getOwnership(i, j + 1) > 0 && map.getOwnership(i, j + 1) != current_city + 1) {
                                if (map.viewMap().get(i).get(j + 1).getValue() > best_value) {
                                    if (cityCheck(current_city, number_cities, i, j + 1, city_table, map)) {
                                        best_x = i;
                                        best_y = j + 1;
                                        best_value = map.viewMap().get(i).get(j + 1).getValue();
                                        add = true;

                                    }
                                }
                            }
                    }
                }
            }

        }


    }

    /**
     * Sprawdza do jakiego miasta nalezy dane pole i czy to miasto ma mniejsza wartosc od miasta obecnego
     * @param current_city numer miasta
     * @param number_cities liczba miast
     * @param x wspolrzedna x
     * @param y wspolrzedna y
     * @param city_table lista miast
     * @param map mapa
     * @return true jesli moze zabrac pole
     */
    protected Boolean cityCheck(int current_city, int number_cities, int x, int y, ArrayList<City> city_table, MapGenerator map) {
        for (int i = 0; i < number_cities; i++) {
            if (current_city != i)
                if (map.getOwnership(x, y) == i + 1)
                    if (city_table.get(current_city).getFortune() > city_table.get(i).getFortune()) {
                        return true;
                    }

        }
        return false;
    }

    /**
     *
     * @return zwraca wspolrzedna x
     */
    public int getBest_x2() {
        return best_x;
    }

    /**
     *
     * @return zwraca wspolrzedna y
     */
    public int getBest_y2() {
        return best_y;
    }

    /**
     *
     * @return zwraca true jesli algorytm wybral nowe najlepsze pole
     */
    public boolean getAdd2() {
        return add;
    }


}
