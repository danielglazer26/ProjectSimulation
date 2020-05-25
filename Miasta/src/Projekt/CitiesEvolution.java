package Projekt;
//nowa wersja
import java.util.ArrayList;

class CitiesEvolution {

    private ArrayList<City> city_table = new ArrayList<>();
    private MapGenerator mapGenerator;
    private int best_x = 0;
    private int best_y = 0;
    private int best_value = 0;
    private boolean add = false;


    protected CitiesEvolution(int map_size, int number_cities, RandomNumber randomNumber) {

        mapGenerator = new MapGenerator(map_size, randomNumber);
        //mapContainer.setTestMap(mapGenerator, map_size);

        CityLocalization.setLocalization(city_table, mapGenerator, number_cities, map_size, randomNumber);

        //mapGenerator.viewOccupied(map_size); //mapa zajetych i wolnych pol
        //mapGenerator.map_viewer(map_size);  //mapa wartosci pol
        //mapContainer.getMap(map_size);
        mapGenerator.map_viewer(map_size);


    }

    protected void cityEvolution(int map_size, int a) {
        city_table.get(a).addLevel();    // zwieksza lvl miasta

        best_x=0;
        best_y=0;
        best_value = 0;
        add = false;
        for (int i = 0; i < map_size; i++) {                           //algorytm wyboru nowego pola KONCEPCJA
            for (int j = 0; j < map_size; j++) {
                if (/*city_table.get(a).getCity_area(i, j) != 0*/getMap().getOwnership(i,j)==a+1) {
                    // Wtedy powinno tu być coś co sprawdza wartości pól wokół pola które należy do miasta
                    // po czym dla jakis wspolrzednych które mają najlepsza wartosc będzie sprawdzać czy pole jest zajete:
                    // algorytm na debila ale powinien działać xD                   //<3 Takie algorytmy najlepsze XDD
                    //zmieniłem na getOwnership
                    if (i > 0)
                        if (/*city_table.get(a).getCity_area(i - 1, j) == 0 && */mapGenerator.getOwnership(i - 1, j)==0) {
                            if (mapGenerator.viewMap().get(i - 1).get(j).getValue() > best_value) {
                                best_x = i - 1;
                                best_y = j;
                                best_value = mapGenerator.viewMap().get(i - 1).get(j).getValue();
                                add = true;
                            }
                        }
                    if (i < map_size - 1)
                        if (/*city_table.get(a).getCity_area(i + 1, j) == 0 && */mapGenerator.getOwnership(i + 1, j)==0) {
                            if (mapGenerator.viewMap().get(i + 1).get(j).getValue() > best_value) {
                                best_x = i + 1;
                                best_y = j;
                                best_value = mapGenerator.viewMap().get(i + 1).get(j).getValue();
                                add = true;
                            }

                        }
                    if (j > 0)
                        if (/*city_table.get(a).getCity_area(i, j - 1) == 0 && */mapGenerator.getOwnership(i, j - 1)==0) {
                            if (mapGenerator.viewMap().get(i).get(j - 1).getValue() > best_value) {
                                best_x = i;
                                best_y = j - 1;
                                best_value = mapGenerator.viewMap().get(i).get(j - 1).getValue();
                                add = true;
                            }
                        }
                    if (j < map_size - 1)
                        if (/*city_table.get(a).getCity_area(i, j + 1) == 0 && */mapGenerator.getOwnership(i, j + 1)==0) {
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
       // if (add) {
            //dodanie pola do miasta
            //city_table.get(a).setCity_area(best_x, best_y, 1);
            //mapGenerator.setOccupied_field(best_x, best_y, true);
            //mapContainer.setMapLocation(best_x, best_y, a + 1);
            //mapGenerator.setOwnership(best_x,best_y,a+1); //zmiana na przechowywanie w klasie Field


        //}


    }

    public int checkField(int x, int y) {
        return mapGenerator.viewMap().get(x).get(y).getValue();
    }
    public int getBest_x1(){
        return best_x;
    }
    public int getBest_y1(){
        return best_y;
    }

    public boolean getAdd1(){
        return add;
    }

    /*public Boolean checkIfField(int x, int y){
        return mapGenerator.getOccupied_field(x,y);
    }*/

    public MapGenerator getMap() {
        return mapGenerator;
    }

    protected ArrayList<City> getCity_table() {
        return city_table;
    }

}
