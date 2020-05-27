package Projekt;
//nowa wersja

import java.util.ArrayList;

class CitiesRelation {

    private final float turn_late_number; // myśle że wpływ miast powinien się pojawiać dopiero później żebby miały opcje się rozwinąć
    private int best_x = 0;
    private int best_y = 0;
    private int best_value = 0;
    private boolean add = false;
    private int city_robbed;


    public CitiesRelation(int turn_number, float agression_rate) {

        turn_late_number = turn_number * (1 - agression_rate);
    }

    protected void cityInfluence(int turn, int map_size, int number_cities, int current_city, ArrayList<City> city_table, MapGenerator map) { // szuka zajętych pól o największej wartośći graniczących z terenami miasta
        // po czym jeśli miasto obecne ma wyższy poziom od miasta od którego pole chce zabrać, zabiera mu je

        add = false;
        //System.out.println("Tura:"+turn+"TLN:"+turn_late_number);
        if (turn >= turn_late_number) {

            best_x = 0;
            best_y = 0;
            best_value = 0;


            for (int i = 0; i < map_size; i++) {
                for (int j = 0; j < map_size; j++) {

                    if (/*city_table.get(current_city).getCity_area(i, j) != 0*/map.getOwnership(i, j) == current_city + 1) {

                        if (i > 0)
                            if (map.getOwnership(i - 1, j) > 0 && map.getOwnership(i - 1, j) != current_city + 1) {
                                if (map.viewMap().get(i - 1).get(j).getValue() > best_value) {
                                    if (cityCheck(current_city, number_cities, i - 1, j, city_table, map)) {
                                        best_x = i - 1;
                                        best_y = j;
                                        best_value = map.viewMap().get(i - 1).get(j).getValue();
                                        add = true;

                                    }
                                }
                            }
                        if (i < map_size - 1)
                            if (map.getOwnership(i + 1, j) > 0 && map.getOwnership(i + 1, j) != current_city + 1) {
                                if (map.viewMap().get(i + 1).get(j).getValue() > best_value) {
                                    if (cityCheck(current_city, number_cities, i + 1, j, city_table, map)) {
                                        best_x = i + 1;
                                        best_y = j;
                                        best_value = map.viewMap().get(i + 1).get(j).getValue();
                                        add = true;

                                    }
                                }

                            }
                        if (j > 0)
                            if (map.getOwnership(i, j - 1) > 0 && map.getOwnership(i, j - 1) != current_city + 1) {
                                if (map.viewMap().get(i).get(j - 1).getValue() > best_value) {
                                    if (cityCheck(current_city, number_cities, i, j - 1, city_table, map)) {
                                        best_x = i;
                                        best_y = j - 1;
                                        best_value = map.viewMap().get(i).get(j - 1).getValue();
                                        add = true;

                                    }
                                }
                            }
                        if (j < map_size - 1)
                            if (map.getOwnership(i, j + 1) > 0 && map.getOwnership(i, j + 1) != current_city + 1) {
                                if (map.viewMap().get(i).get(j + 1).getValue() > best_value) {
                                    if (cityCheck(current_city, number_cities, i, j + 1, city_table, map)) {
                                        best_x = i;
                                        best_y = j + 1;
                                        best_value = map.viewMap().get(i).get(j + 1).getValue();
                                        add = true;

                                    }
                                }
                            }
                    }
                }
            }
            // if (add) {
            //city_table.get(current_city).setCity_area(best_x, best_y, 1);
            //city_table.get(city_robbed).setCity_area(best_x, best_y, 0);
            //mapContainer.setMapLocation(best_x, best_y, current_city + 1);
            //map.setOwnership(best_x,best_y,current_city+1);


            //  }


        }


    }

    private Boolean cityCheck(int current_city, int number_cities, int x, int y, ArrayList<City> city_table, MapGenerator map) { // funkcja sprawdzająca do jakiego miasta należy dane pole i czy to miasto ma niższy poziom od miasta obecnego
        for (int i = 0; i < number_cities; i++) {
            if (current_city != i)
                if (/*city_table.get(i).getCity_area(x, y) == 1*/map.getOwnership(x, y) == i + 1)
                    if (city_table.get(current_city).getCity_level() > city_table.get(i).getCity_level()) {
                        city_robbed = i;
                        return true;
                    }

        }
        return false;
    }

    public int getBest_x2() {
        return best_x;
    }

    public int getBest_y2() {
        return best_y;
    }

    public boolean getAdd2() {
        return add;
    }


}
