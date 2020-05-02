package Projekt;

import java.util.ArrayList;

class CitiesEvolution  {

    ArrayList<City> city_table = new ArrayList<>();

    protected CitiesEvolution(int map_size, int number_cities){

        for(int i = 0; i < number_cities; i++)
        {
            city_table.add(new City(map_size));
        }
        map = new MapGenerator(map_size);
    }
    MapGenerator map;

    public  int checkField(int x, int y){
        return map.viewMap().get(x).get(y).getValue();
    }
    protected ArrayList<City> getCity_table() {return  city_table;}

}
