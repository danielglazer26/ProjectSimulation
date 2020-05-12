package Projekt;

import java.util.ArrayList;

class CitiesEvolution  {

    ArrayList<City> city_table = new ArrayList<>();
    MapGenerator map;
    private int best_x=0;
    private int best_y=0;
    private int best_value=0;
    private boolean add = false;


    protected CitiesEvolution(int map_size, int number_cities,RandomNumber randomNumber){

        map = new MapGenerator(map_size,randomNumber);
        for(int i = 0; i < number_cities; i++)
        {
            //miasta nie mogą pojawić się w tym samym miejscu

            city_table.add(new City(map_size,randomNumber));
            do{city_table.get(i).localizationChange(map_size,randomNumber);
            }while(map.getOccupied_field(city_table.get(i).getX(),city_table.get(i).getY()));
            map.setOccupied_field(city_table.get(i).getX(),city_table.get(i).getY(),true); //ustawienie że pole jest zajęte
            city_table.get(i).setStartArea(); //ustawienie CityArea
        }

        map.viewOccupied(map_size); //dev
        map.map_viewer(map_size);



    }

    protected void cityEvolution(int map_size, int a){
        city_table.get(a).addLevel();    // zwieksza lvl miasta

        for (int i = 0; i < map_size; i++) {                           //algorytm wyboru nowego pola KONCEPCJA
            for (int j = 0; j < map_size; j++) {
                if(city_table.get(a).getCity_area(i, j) != 0){
                    // Wtedy powinno tu być coś co sprawdza wartości pól wokół pola które należy do miasta
                    // po czym dla jakis wspolrzednych które mają najlepsza wartosc będzie sprawdzać czy pole jest zajete:
                      // algorytm na debila ale powinien działać xD
                    if(i>0)
                    if(city_table.get(a).getCity_area(i-1, j)==0 && !map.getOccupied_field(i-1, j)){
                        if(map.viewMap().get(i-1).get(j).getValue()>best_value){
                        best_x=i-1;
                        best_y=j;
                        best_value=map.viewMap().get(i-1).get(j).getValue();
                        add=true;}
                    }
                    if(i<map_size-1)
                    if(city_table.get(a).getCity_area(i+1, j)==0 && !map.getOccupied_field(i+1, j)){
                        if(map.viewMap().get(i+1).get(j).getValue()>best_value){
                            best_x=i+1;
                            best_y=j;
                            best_value=map.viewMap().get(i+1).get(j).getValue();
                            add=true;}

                    }
                    if(j>0)
                    if(city_table.get(a).getCity_area(i, j-1)==0 && !map.getOccupied_field(i, j-1)){
                        if(map.viewMap().get(i).get(j-1).getValue()>best_value){
                            best_x=i;
                            best_y=j-1;
                            best_value=map.viewMap().get(i).get(j-1).getValue();
                            add=true;}
                    }
                    if(j<map_size-1)
                    if(city_table.get(a).getCity_area(i, j+1)==0 && !map.getOccupied_field(i, j+1)){
                        if(map.viewMap().get(i).get(j+1).getValue()>best_value){
                            best_x=i;
                            best_y=j+1;
                            best_value=map.viewMap().get(i).get(j+1).getValue();
                            add=true;
                        }
                    }
                }
            }
        }
        if(add){
            city_table.get(a).setCity_area(best_x, best_y, 1);
            map.setOccupied_field(best_x,best_y,true);}
        best_value=0;
        add=false;
    }

    public  int checkField(int x, int y){
        return map.viewMap().get(x).get(y).getValue();
    }
    protected ArrayList<City> getCity_table() {return  city_table;}

}
