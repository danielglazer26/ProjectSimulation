package Projekt;

import java.util.ArrayList;

class CitiesEvolution  {

    ArrayList<City> city_table = new ArrayList<>();
    MapGenerator map;

    protected CitiesEvolution(int map_size, int number_cities){

        for(int i = 0; i < number_cities; i++)
        {
            city_table.add(new City(map_size));
        }
        map = new MapGenerator(map_size);
    }

    protected void cityEvolution(int map_size, int a){
        city_table.get(a).addLevel();    // zwieksza lvl miasta

        for (int i = 0; i < map_size; i++) {                           //algorytm wyboru nowego pola KONCEPCJA
            for (int j = 0; j < map_size; j++) {
                if(city_table.get(a).getCity_area(i, j) != 0){
                    // Wtedy powinno tu być coś co sprawdza wartości pól wokół pola które należy do miasta
                    // po czym dla jakis wspolrzednych które mają najlepsza wartosc będzie sprawdzać czy pole jest zajete:
                     if(!map.getOccupied_field(i, j));
                     //jak nie jest to dodaje do miasta pole
                    city_table.get(a).setCity_area(i, j, 1);

                }
            }
        }

    }

    public  int checkField(int x, int y){
        return map.viewMap().get(x).get(y).getValue();
    }
    protected ArrayList<City> getCity_table() {return  city_table;}

}
