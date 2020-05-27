package Projekt;
//nowa wersja
 class TurnValue {  //zlicza wartości pól dla danego miasta i sprawdza czy miasta może osiągnąć kolejny lvl

    private int areas_value;

    public Boolean checkCityUpgrade (int city_value, int city_level){   //sprawdza czy miasto może zlevelować
        if (city_value > city_level * 50 )
            return  true;
        else
            return false;

    }
    public int countFieldValue(int map_size, int city_number, CitiesEvolution citiesEvolution){      //zlicza wartosc wszystkich posiadanych pól
        areas_value = 0;
        for(int i = 0; i< map_size; i++ ){
            for (int j = 0; j < map_size; j++) {
                if(citiesEvolution.getMap().getOwnership(i,j)==city_number+1){   //*zmiana*
                    areas_value += citiesEvolution.checkField(i,j);
                }
            }
        }

        return areas_value;
    }

}
