package Projekt;

import java.util.ArrayList;

/**
 * Klasa odpowiadajaca za ustwaienie lokalizacji startowej miast
 */
abstract class CityLocalization {
    protected static void setLocalization(ArrayList<City> city_table, MapGenerator map, int number_cities, int map_size, RandomNumber randomNumber) {

        for (int i = 0; i < number_cities; i++) {

            city_table.add(new City(map_size, randomNumber));
            do {
                city_table.get(i).localizationChange(map_size, randomNumber);
            } while (map.getOwnership(city_table.get(i).getX(), city_table.get(i).getY()) != 0 || map.getValue(city_table.get(i).getX(), city_table.get(i).getY()) == -1);
            map.setOwnership(city_table.get(i).getX(), city_table.get(i).getY(), i + 1); //ustawienie że pole jest zajęte
        }
    }


}
