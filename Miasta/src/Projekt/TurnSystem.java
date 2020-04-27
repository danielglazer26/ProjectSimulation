package Projekt;

class TurnSystem {


    CitiesEvolution city;
    CitiesRelation citiesRelation;
     TurnValue turnValue;

    protected TurnSystem(int map_size, int number_cities){
         city = new CitiesEvolution(map_size, number_cities);
         citiesRelation = new CitiesRelation();
        turnValue = new TurnValue();
    }



    protected void simulationTurn(){
        for(int i = 0; i < 5; i++){
            System.out.println(city.getCity_table().get(i).city_area[3][5]);
        }
        city.getCity_table().get(0).addFortune(city.checkField(3,5));
        citiesRelation.changeLevel(city);
        turnValue.checkCityUpgrade(city);
    }

}
