package Projekt;

 class TurnValue {

    private int areas_value = 0;

    public Boolean checkCityUpgrade (int city_value, int city_level){
        if (city_value > city_level * 15 )
            return  true;
        else
            return false;

    }
    public int countFieldValue(int map_size, int[][] city_area, CitiesEvolution citiesEvolution){            //zlicza wartosc wszystkich posiadanych pól
        for(int i = 0; i< map_size; i++ ){
            for (int j = 0; j < map_size; j++) {
                if(city_area[i][j] == 1 || city_area[i][j] == 2){                                           // jedynka dla pola dodanego dzięki lvl miasta
                    areas_value += citiesEvolution.checkField(i,j);                                         // dwójka lokalizacja startowa miasta
                }
            }
        }

        return areas_value;
    }

}
