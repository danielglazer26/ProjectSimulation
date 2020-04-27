package Projekt;

import java.util.ArrayList;
import java.util.List;

 class MapGenerator {

    List<List<Field>> map = new ArrayList<List<Field>>();

    protected MapGenerator(int a) {


        for (int i = 0; i < a; i++) {
            map.add(new ArrayList<Field>());
        }
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++) {
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
}
