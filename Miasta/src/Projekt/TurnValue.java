package Projekt;

//nowa wersja
abstract class TurnValue {  //zlicza wartości pól dla danego miasta i sprawdza czy miasta może osiągnąć kolejny lvl

    public static Boolean checkCityUpgrade(int city_value, int fields_number) {   //sprawdza czy miasto może zlevelować
        if (city_value > (49 + fields_number) * fields_number * fields_number) {
            System.out.println(fields_number);
            return true;
        } else
            return false;

    }

    public static int countFieldValue(int map_size, int city_number, CitiesEvolution citiesEvolution) {      //zlicza wartosc wszystkich posiadanych pól
        int areas_value = 0;
        citiesEvolution.getCity_table().get(city_number).setFields_number();
        for (int i = 0; i < map_size; i++) {
            for (int j = 0; j < map_size; j++) {
                if (citiesEvolution.getMap().getOwnership(i, j) == city_number + 1) {   //*zmiana*
                    areas_value += citiesEvolution.checkField(i, j);
                    citiesEvolution.getCity_table().get(city_number).addFields_number();
                }
            }
        }

        return areas_value;
    }

}
