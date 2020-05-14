package Projekt;

class MapContainer {

    int[][] map_container;
    int[][] test_map;

    MapContainer(int map_size) {

        map_container = new int[map_size][map_size];
        test_map = new int[map_size][map_size];
        for (int i = 0; i < map_size; i++) {
            for (int j = 0; j < map_size; j++) {
                map_container[i][j] = 0;
                test_map[i][j] = 0;
            }
        }
    }

    public void setMapLocation(int x, int y, int z) {
        map_container[x][y] = z;
        test_map[x][y] = z;
    }

    public int getMapLocation(int x, int y) {
        return map_container[x][y];
    }

    public void getMap(int map_size) {
        for (int i = 0; i < map_size; i++) {
            for (int j = 0; j < map_size; j++) {
                System.out.print(map_container[i][j] + "   ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void getTestMap(int map_size, int turn) {

        System.out.println("Tura: "+ turn);
        for (int i = 0; i < map_size; i++) {
            for (int j = 0; j < map_size; j++) {
                System.out.print(test_map[i][j] + "   ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void setTestMap(MapGenerator mapGenerator, int map_size) {
        for (int i = 0; i < map_size; i++)
            for (int j = 0; j < map_size; j++) {
                test_map[i][j] = mapGenerator.viewMap().get(i).get(j).getValue();
            }
    }
}
