package Projekt;
//nowa wersja
class TurnSystem {   //Odpowiada za cały system tur


    //MapContainer mapContainer;
    CitiesEvolution citiesEvolution;
    CitiesRelation citiesRelation;
    TurnValue turnValue;


    protected TurnSystem(int turn_number, int map_size, int number_cities, float agression_rate, RandomNumber randomNumber) {
       // mapContainer = new MapContainer(map_size);
        citiesEvolution = new CitiesEvolution(map_size, number_cities, randomNumber);
        citiesRelation = new CitiesRelation(turn_number, agression_rate);
        turnValue = new TurnValue();
    }

    protected void simulationTurn(int map_size, int turn_number, int number_cities) {
        //mapContainer.getTestMap(map_size, turn_number);
        citiesEvolution.getMap().value_viewer(map_size);
        for (int i = turn_number; i > 0; i--) {                              //Tura wszystkich miast
            for (int j = 0; j < number_cities; j++) {                       //Tura pojedynczego miasta

                citiesEvolution.getCity_table().get(j).addFortune(turnValue.countFieldValue(map_size, j, citiesEvolution));
                // dodanie wartości wynikającej z posiadanych pól

                //wygląda okropnie a działa jeszcze lepiej XDDD
                //chodzi w skrócie o to żeby miasto w jednej turze nie brało wolnego pola i jednocześnie pola innego miasta

                if (turnValue.checkCityUpgrade(citiesEvolution.getCity_table().get(j).getFortune(), citiesEvolution.getCity_table().get(j).getCity_level())) { //sprawdzenie czy może zlevelować
                    citiesEvolution.cityEvolution(map_size, j);
                    citiesRelation.cityInfluence(turn_number - i, map_size, number_cities, j, citiesEvolution.getCity_table(),citiesEvolution.getMap());
                    if(citiesEvolution.getAdd1() && citiesRelation.getAdd2()){
                    if(citiesEvolution.getMap().getValue(citiesEvolution.getBest_x1(),citiesEvolution.getBest_y1())>citiesEvolution.getMap().getValue(citiesRelation.getBest_x2(),citiesRelation.getBest_y2())){
                        citiesEvolution.getMap().setOwnership(citiesEvolution.getBest_x1(),citiesEvolution.getBest_y1(),j+1);
                    }else {
                        citiesEvolution.getMap().setOwnership(citiesRelation.getBest_x2(),citiesRelation.getBest_y2(),j+1);
                    }

                }else{
                        if(citiesEvolution.getAdd1()){
                            citiesEvolution.getMap().setOwnership(citiesEvolution.getBest_x1(),citiesEvolution.getBest_y1(),j+1);
                        }else{
                            citiesEvolution.getMap().setOwnership(citiesRelation.getBest_x2(),citiesRelation.getBest_y2(),j+1);
                        }
                    }

                }
            }//mapContainer.getMap(map_size, turn_number - i); //wyswietla mape
            //mapContainer.getTestMap(map_size, turn_number - i); //wyswietla mape testowa
            citiesEvolution.getMap().map_viewer(map_size);
        }
    }

}
