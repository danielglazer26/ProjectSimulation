package Projekt;

class TurnSystem {


    MapContainer mapContainer;
    CitiesEvolution citiesEvolution;
    CitiesRelation citiesRelation;
    TurnValue turnValue;


    protected TurnSystem(int turn_number, int map_size, int number_cities, RandomNumber randomNumber) {
        mapContainer = new MapContainer(map_size);
        citiesEvolution = new CitiesEvolution(map_size, number_cities, randomNumber, mapContainer);
        citiesRelation = new CitiesRelation(turn_number);
        turnValue = new TurnValue();
    }

    protected void simulationTurn(int map_size, int turn_number, int number_cities) {
        //mapContainer.getTestMap(map_size, turn_number);
        for (int i = turn_number; i > 0; i--) {                              //Tura wszystkich miast
            for (int j = 0; j < number_cities; j++) {                       //Tura pojedynczego miasta

                citiesRelation.cityInfluence(turn_number - i, map_size, number_cities, j, citiesEvolution.getCity_table(),citiesEvolution.getMap(), mapContainer);
                citiesEvolution.getCity_table().get(j).addFortune(turnValue.countFieldValue(map_size, citiesEvolution.getCity_table().get(j).getCity_area(), citiesEvolution));
                // dodanie wartości wynikającej z posiadanych pól

                if (turnValue.checkCityUpgrade(citiesEvolution.getCity_table().get(j).getFortune(), citiesEvolution.getCity_table().get(j).getCity_level())) { //sprawdzenie czy może zlevelować
                    citiesEvolution.cityEvolution(map_size, j, mapContainer);
                }
            }mapContainer.getMap(map_size, turn_number - i); //wyswietla mape
            //mapContainer.getTestMap(map_size, turn_number - i); //wyswietla mape testowa
        }
    }

}
