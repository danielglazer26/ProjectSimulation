package Projekt;
//nowa wersja
import java.util.ArrayList;
import java.util.List;

public class MapGenerator {

    List<List<Field>> map = new ArrayList<List<Field>>(); //dwuwymiarowa lista przechowująca obiekty pól

    //private boolean[][] occupied_field;           //tablica na razie tylko jako pomysł żeby rozwiązać problem z tym czy pole jest zajęte już przez kogoś czy nie

    protected MapGenerator(int map_size, RandomNumber randomNumber) {

        //occupied_field = new boolean[map_size][map_size];

        for (int i = 0; i < map_size; i++) {
            map.add(new ArrayList<Field>());
        }
        for (int i = 0; i < map_size; i++) {
            for (int j = 0; j < map_size; j++) {
                switch (randomNumber.getRandomNumber(4)) {

                    case 0:
                        map.get(i).add(j, new Forest());
                        break;

                    case 1:
                        map.get(i).add(j, new Mountain());
                        break;

                    case 2:
                        map.get(i).add(j, new Sand());
                        break;

                    case 3:
                        map.get(i).add(j, new Lake());
                        //occupied_field[i][j] = true;
                        break;

                }
            }
        }

    }

    public List<List<Field>> viewMap() {
        return map;
    }

    protected int getOwnership(int x,int y){
        return map.get(x).get(y).getOwnership();
    }

    protected void setOwnership(int x, int y, int own){
        map.get(x).get(y).setOwnership(own);
    }


    /*protected boolean getOccupied_field(int x, int y) {
        return occupied_field[x][y];
    }

    protected void setOccupied_field(int x, int y, boolean z) {
        occupied_field[x][y] = z;
    }

    protected boolean[][] getOccupied_field() {
        return occupied_field;
    }

    protected void viewOccupied(int map_size) {  //zaznacza też Lake, nie wiem czy tak ma być
        for (int i = 0; i < map_size; i++) {
            for (int j = 0; j < map_size; j++) {
                if (occupied_field[i][j])
                    System.out.print(1 + " ");
                else {
                    System.out.print(0 + " ");
                }
                ;
            }
            System.out.println();
        }
        System.out.println();
    }
*/
    protected void map_viewer(int map_size) //wersja deweloperska do sprawdzania mapy, potem się to wywali
    {
        for (int i = 0; i < map_size; i++) {
            for (int j = 0; j < map_size; j++) {
                //System.out.print("["+map.get(i).get(j).getOwnership()+"]"+map.get(i).get(j).getValue()+" ");
                System.out.print(map.get(i).get(j).getOwnership()+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    protected void value_viewer(int map_size) //wersja deweloperska do sprawdzania mapy, potem się to wywali
    {
        for (int i = 0; i < map_size; i++) {
            for (int j = 0; j < map_size; j++) {
                System.out.print(map.get(i).get(j).getValue()+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    protected int getValue(int x, int y){
        return map.get(x).get(y).getValue();
    }
}




