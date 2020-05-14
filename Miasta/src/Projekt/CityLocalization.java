package Projekt;

import java.util.ArrayList;

abstract class CityLocalization {
    protected static void setLocalization(MapContainer mapContainer, ArrayList<City> city_table, MapGenerator map, int number_cities, int map_size, RandomNumber randomNumber) {

        for (int i = 0; i < number_cities; i++) {

            city_table.add(new City(map_size, randomNumber));
            do {
                city_table.get(i).localizationChange(map_size, randomNumber);
            } while (map.getOccupied_field(city_table.get(i).getX(), city_table.get(i).getY()));
            map.setOccupied_field(city_table.get(i).getX(), city_table.get(i).getY(), true); //ustawienie że pole jest zajęte
            city_table.get(i).setStartArea(); //ustawienie CityArea
            mapContainer.setMapLocation(city_table.get(i).getX(), city_table.get(i).getY(), i + 1);
        }
    }
    //Tutaj trzeba jakis sensowny warunek wymyślić na ustalanie lokalizacji startowych miast
    //jakoś udało się bez tego, nie wiem czy ta klasa jest potrzebna wgl


}
