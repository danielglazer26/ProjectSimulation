package Projekt;


public class TurnSystem  {   //Odpowiada za cały system tur


    public CitiesEvolution citiesEvolution;
    private final CitiesRelation citiesRelation;
    TurnValue turnValue;

    public TurnSystem(int turn_number, int map_size, int number_cities, float agression_rate, RandomNumber randomNumber) {

        citiesEvolution = new CitiesEvolution(map_size, number_cities, randomNumber);
        citiesRelation = new CitiesRelation(turn_number, agression_rate);
        turnValue = new TurnValue();
    }

    public void simulationTurn(int i, int map_size, int turn_number, int number_cities) { //Jakbys sie zastanawial gdzie jest jedna petla to spiesze z pomoca classa TextWindow (Jebane okienka)

        citiesEvolution.getMap().value_viewer(map_size);

        for (int j = 0; j < number_cities; j++) {                       //Tura pojedynczego miasta

            citiesEvolution.getCity_table().get(j).addFortune(turnValue.countFieldValue(map_size, j, citiesEvolution));
            // dodanie wartości wynikającej z posiadanych pól

            //wygląda okropnie a działa jeszcze lepiej XDDD  //<3
            //chodzi w skrócie o to żeby miasto w jednej turze nie brało wolnego pola i jednocześnie pola innego miasta

            if (turnValue.checkCityUpgrade(citiesEvolution.getCity_table().get(j).getFortune(), citiesEvolution.getCity_table().get(j).getCity_level())) { //sprawdzenie czy może zlevelować
                citiesEvolution.cityEvolution(map_size, j);
                citiesRelation.cityInfluence(turn_number - i, map_size, number_cities, j, citiesEvolution.getCity_table(), citiesEvolution.getMap());
                if (citiesEvolution.getAdd1() && citiesRelation.getAdd2()) {
                    if (citiesEvolution.getMap().getValue(citiesEvolution.getBest_x1(), citiesEvolution.getBest_y1()) > citiesEvolution.getMap().getValue(citiesRelation.getBest_x2(), citiesRelation.getBest_y2())) {
                        citiesEvolution.getMap().setOwnership(citiesEvolution.getBest_x1(), citiesEvolution.getBest_y1(), j + 1);
                    } else {
                        citiesEvolution.getMap().setOwnership(citiesRelation.getBest_x2(), citiesRelation.getBest_y2(), j + 1);
                    }

                } else {
                    if (citiesEvolution.getAdd1()) {
                        citiesEvolution.getMap().setOwnership(citiesEvolution.getBest_x1(), citiesEvolution.getBest_y1(), j + 1);
                    } else {
                        citiesEvolution.getMap().setOwnership(citiesRelation.getBest_x2(), citiesRelation.getBest_y2(), j + 1);
                    }
                }

            }
        }
        citiesEvolution.getMap().map_viewer(map_size);
    }
}


