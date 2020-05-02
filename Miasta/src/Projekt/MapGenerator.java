package Projekt;

import java.util.ArrayList;
import java.util.List;

 class MapGenerator {

    List<List<Field>> map = new ArrayList<List<Field>>();

     private boolean[][] occupied_field;           //tablica na razie tylko jako pomysł żeby rozwiązać problem z tym czy pole jest zajęte już przez kogoś czy nie


    protected MapGenerator(int map_size) {

        occupied_field = new boolean[map_size][map_size];

        for (int i = 0; i < map_size; i++) {
            map.add(new ArrayList<Field>());
        }
        for (int i = 0; i < map_size; i++) {
            for (int j = 0; j < map_size; j++) {
                switch (RandomNumber.getRandomNumber(4)){

                    case 0:
                        map.get(i).add(j,new Forest());
                    break;

                    case 1:
                        map.get(i).add(j,new Mountain());
                        break;

                    case 2:
                        map.get(i).add(j,new Sand());
                        break;

                    case 3:
                        map.get(i).add(j,new Lake());
                        break;

                }
            }
        }

    }
    protected List<List<Field>> viewMap(){
        return map;
    }

     protected boolean getOccupied_field(int x, int y) {
         return occupied_field[x][y];
     }
     protected boolean[][] getOccupied_field() {
         return occupied_field;
     }

}
