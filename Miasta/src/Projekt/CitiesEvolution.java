package Projekt;

import java.util.ArrayList;

public class CitiesEvolution {

    private ArrayList<City> city_table = new ArrayList<>();
    private MapGenerator mapGenerator;
    private int best_x;
    private int best_y;
    private int best_value;
    private boolean add;


    protected CitiesEvolution(int map_size, int number_cities, RandomNumber randomNumber) {

        mapGenerator = new MapGenerator(map_size, randomNumber);

        CityLocalization.setLocalization(city_table, mapGenerator, number_cities, map_size, randomNumber);

        mapGenerator.map_viewer(map_size);


    }

    protected void cityEvolution(int map_size, int a) {
        //city_table.get(a).addLevel();    // zwieksza lvl miasta

        best_x = 0;
        best_y = 0;
        best_value = 0;
        add = false;
        for (int i = 0; i < map_size; i++) {                           //algorytm wyboru nowego pola KONCEPCJA
            for (int j = 0; j < map_size; j++) {
                if (getMap().getOwnership(i, j) == a + 1) {
                    // Wtedy powinno tu być coś co sprawdza wartości pól wokół pola które należy do miasta
                    // po czym dla jakis wspolrzednych które mają najlepsza wartosc będzie sprawdzać czy pole jest zajete:
                    // algorytm na debila ale powinien działać xD                   //<3 Takie algorytmy najlepsze XDD
                    //zmieniłem na getOwnership
                    if (i > 0)
                        if (mapGenerator.getOwnership(i - 1, j) == 0) {
                            if (mapGenerator.viewMap().get(i - 1).get(j).getValue() > best_value) {
                                best_x = i - 1;
                                best_y = j;
                                best_value = mapGenerator.viewMap().get(i - 1).get(j).getValue();
                                add = true;
                            }
                        }
                    if (i < map_size - 1)
                        if (mapGenerator.getOwnership(i + 1, j) == 0) {
                            if (mapGenerator.viewMap().get(i + 1).get(j).getValue() > best_value) {
                                best_x = i + 1;
                                best_y = j;
                                best_value = mapGenerator.viewMap().get(i + 1).get(j).getValue();
                                add = true;
                            }

                        }
                    if (j > 0)
                        if (mapGenerator.getOwnership(i, j - 1) == 0) {
                            if (mapGenerator.viewMap().get(i).get(j - 1).getValue() > best_value) {
                                best_x = i;
                                best_y = j - 1;
                                best_value = mapGenerator.viewMap().get(i).get(j - 1).getValue();
                                add = true;
                            }
                        }
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

    public int checkField(int x, int y) {
        return mapGenerator.viewMap().get(x).get(y).getValue();
    }

    public int getBest_x1() {
        return best_x;
    }

    public int getBest_y1() {
        return best_y;
    }

    public boolean getAdd1() {
        return add;
    }

    public MapGenerator getMap() {
        return mapGenerator;
    }

    public ArrayList<City> getCity_table() {
        return city_table;
    }

}
