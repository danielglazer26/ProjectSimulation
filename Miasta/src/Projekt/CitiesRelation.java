package Projekt;

class CitiesRelation  {

    protected int city_influence;


    protected void changeLevel(CitiesEvolution ce){
        if(city_influence<3)
        ce.getCity_table().get(1).decreaseLevel();
        ce.getCity_table().get(2).decreaseLevel();
    }


}
