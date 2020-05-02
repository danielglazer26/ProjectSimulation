package Projekt;

class City {

    private int fortune = 5;
    private int city_level = 1;
    private int[][] city_area;

    protected City(int map_size){
         city_area = new int[map_size][map_size];
        city_area[CityLocalization.setLocalization(map_size)][CityLocalization.setLocalization(map_size)] = 2;
    }

    protected void addFortune(int fortune){
        this.fortune += fortune;
    }
    protected int getFortune(){return  fortune;}

    public int getCity_level(){ return city_level; }
    protected void addLevel(){ this.city_level += 1; }
    protected void decreaseLevel(){ this.city_level -= 1; }

    public int getCity_area(int x, int y){ return city_area[x][y];}
    public int[][] getCity_area(){ return city_area;}
    public void setCity_area(int x, int y, int value ) { city_area[x][y] = value; }


}


