package Projekt;

class TurnSystem {


    CitiesEvolution citiesEvolution;
    CitiesRelation citiesRelation;
     TurnValue turnValue;

    protected TurnSystem(int map_size, int number_cities){
         citiesEvolution = new CitiesEvolution(map_size, number_cities);
         citiesRelation = new CitiesRelation();
        turnValue = new TurnValue();
    }



    protected void simulationTurn(int map_size, int turn_number, int number_cities){
        for(int i = turn_number; i > 0; i--) {                              //Tura wszystkich miast
            for(int j = 0; j < number_cities; j++) {                       //Tura pojedynczego miasta
               citiesEvolution.getCity_table().get(j).addFortune(turnValue.countFieldValue(map_size, citiesEvolution.getCity_table().get(j).city_area, citiesEvolution));
               // dodanie wartości wynikającej z posiadanych pól

            }
        }
    }

}
