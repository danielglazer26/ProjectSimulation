package Projekt;



/**
 * Klasa odpowiadajaca za mozliwosc rozwoju miast (przejecia pola)
 */
public abstract class TurnValue {
    /**
     * Sprawdza czy miasto moze przejac kolejne pole
     * @param city_value wartosc miasta
     * @param fields_number liczba pol miasta
     * @return zwraca true jesli miasto moze sie rozwinac, false jesli nie
     */
    public static Boolean checkCityUpgrade(int city_value, int fields_number) {
        return city_value > (49 + fields_number) * fields_number * fields_number;

    }

    /**
     * Zlicza wartosc wszystkich posiadanych pól co ture
     * @param map_size szerokosc mapy
     * @param city_number liczba miast
     * @param citiesEvolution obiekt odpowiadajacy za ewolucje miast
     * @return warosc miasta
     */
    public static int countFieldValue(int map_size, int city_number, CitiesEvolution citiesEvolution) {
        int areas_value = 0;
        citiesEvolution.getCity_table().get(city_number).setFields_number();
        for (int i = 0; i < map_size; i++) {
            for (int j = 0; j < map_size; j++) {
                if (citiesEvolution.getMap().getOwnership(i, j) == city_number + 1) {
                    areas_value += citiesEvolution.checkField(i, j);
                    citiesEvolution.getCity_table().get(city_number).addFields_number();
                }
            }
        }

        return areas_value;
    }

}
