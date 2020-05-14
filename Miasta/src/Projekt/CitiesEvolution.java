package Projekt;

import java.util.ArrayList;

class CitiesEvolution {

    private ArrayList<City> city_table = new ArrayList<>();
    private MapGenerator mapGenerator;
    private int best_x = 0;
    private int best_y = 0;
    private int best_value = 0;
    private boolean add = false;


    protected CitiesEvolution(int map_size, int number_cities, RandomNumber randomNumber, MapContainer mapContainer) {

        mapGenerator = new MapGenerator(map_size, randomNumber);
        mapContainer.setTestMap(mapGenerator, map_size);

        CityLocalization.setLocalization(mapContainer, city_table, mapGenerator, number_cities, map_size, randomNumber);

        mapGenerator.viewOccupied(map_size); //dev
        mapGenerator.map_viewer(map_size);
        //mapContainer.getMap(map_size);


    }

    protected void cityEvolution(int map_size, int a, MapContainer mapContainer) {
        city_table.get(a).addLevel();    // zwieksza lvl miasta

        for (int i = 0; i < map_size; i++) {                           //algorytm wyboru nowego pola KONCEPCJA
            for (int j = 0; j < map_size; j++) {
                if (city_table.get(a).getCity_area(i, j) != 0) {
                    // Wtedy powinno tu być coś co sprawdza wartości pól wokół pola które należy do miasta
                    // po czym dla jakis wspolrzednych które mają najlepsza wartosc będzie sprawdzać czy pole jest zajete:
                    // algorytm na debila ale powinien działać xD                   //<3 Takie algorytmy najlepsze XDD
                    if (i > 0)
                        if (city_table.get(a).getCity_area(i - 1, j) == 0 && !mapGenerator.getOccupied_field(i - 1, j)) {
                            if (mapGenerator.viewMap().get(i - 1).get(j).getValue() > best_value) {
                                best_x = i - 1;
                                best_y = j;
                                best_value = mapGenerator.viewMap().get(i - 1).get(j).getValue();
                                add = true;
                            }
                        }
                    if (i < map_size - 1)
                        if (city_table.get(a).getCity_area(i + 1, j) == 0 && !mapGenerator.getOccupied_field(i + 1, j)) {
                            if (mapGenerator.viewMap().get(i + 1).get(j).getValue() > best_value) {
                                best_x = i + 1;
                                best_y = j;
                                best_value = mapGenerator.viewMap().get(i + 1).get(j).getValue();
                                add = true;
                            }

                        }
                    if (j > 0)
                        if (city_table.get(a).getCity_area(i, j - 1) == 0 && !mapGenerator.getOccupied_field(i, j - 1)) {
                            if (mapGenerator.viewMap().get(i).get(j - 1).getValue() > best_value) {
                                best_x = i;
                                best_y = j - 1;
                                best_value = mapGenerator.viewMap().get(i).get(j - 1).getValue();
                                add = true;
                            }
                        }
                    if (j < map_size - 1)
                        if (city_table.get(a).getCity_area(i, j + 1) == 0 && !mapGenerator.getOccupied_field(i, j + 1)) {
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
        if (add) {
            city_table.get(a).setCity_area(best_x, best_y, 1);
            mapGenerator.setOccupied_field(best_x, best_y, true);
            mapContainer.setMapLocation(best_x, best_y, a + 1);
            //System.out.println("Działa");
        }

        best_value = 0;
        add = false;
    }

    public int checkField(int x, int y) {
        return mapGenerator.viewMap().get(x).get(y).getValue();
    }

    public Boolean checkIfField(int x, int y){
        return mapGenerator.getOccupied_field(x,y);
    }

    public MapGenerator getMap() {
        return mapGenerator;
    }

    protected ArrayList<City> getCity_table() {
        return city_table;
    }

}
