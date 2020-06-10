package Projekt;

/**
 * Odpowiada za caly system tur
 */

public class TurnSystem  {

    /**obiekt odpowiadajacy za ewolucje miast*/
    public CitiesEvolution citiesEvolution;
    /**obiekt odpowiadajacy za relacje miast*/
    private final CitiesRelation citiesRelation;

    /**
     * Tworzy obiekty, ktore odpowiadaja za ewolucje i relacje miast
     * @param turn_number liczba wszystkich tur symulacji
     * @param map_size szerokosc mapy
     * @param number_cities liczba miast
     * @param agression_rate wspolczynnik agresji
     * @param randomNumber obiekt odpowiadajacy za liczby pseudolosowe
     */
    public TurnSystem(int turn_number, int map_size, int number_cities, float agression_rate, RandomNumber randomNumber) {

        citiesEvolution = new CitiesEvolution(map_size, number_cities, randomNumber);
        citiesRelation = new CitiesRelation(turn_number, agression_rate);
    }

    /**
     * Odpowiada za przeprowadzenie tur w symulacji.
     * @param i numer obecnej tury
     * @param map_size szerokosc mapy
     * @param number_cities liczba miast
     */

    public void simulationTurn(int i, int map_size, int number_cities) {

        //wyswietlenie wartosci w konsoli
        //citiesEvolution.getMap().value_viewer(map_size);

        for (int j = 0; j < number_cities; j++) {      //Tura pojedynczego miasta

            // dodanie wartości wynikającej z posiadanych pól
            citiesEvolution.getCity_table().get(j).addFortune(TurnValue.countFieldValue(map_size, j, citiesEvolution));

            //Sprawdza czy maisto moze sie rozwinac
            if (TurnValue.checkCityUpgrade(citiesEvolution.getCity_table().get(j).getFortune(), citiesEvolution.getCity_table().get(j).getFields_number())) {
                citiesEvolution.cityEvolution(map_size, j);
                citiesRelation.cityInfluence(i, map_size, number_cities, j, citiesEvolution.getCity_table(), citiesEvolution.getMap());
                //sprawdzenie czy misto wybralo najlepsze pola (wolne pole, pole innego miata)
                if (citiesEvolution.getAdd1() && citiesRelation.getAdd2()) {
                    //sprawdzanie ktore pole ma wieksza wartosc
                    if (citiesEvolution.getMap().getValue(citiesEvolution.getBest_x1(), citiesEvolution.getBest_y1()) > citiesEvolution.getMap().getValue(citiesRelation.getBest_x2(), citiesRelation.getBest_y2())) {
                        //miasto przejmuje pole
                        citiesEvolution.getMap().setOwnership(citiesEvolution.getBest_x1(), citiesEvolution.getBest_y1(), j + 1);
                    } else {
                        //miasto przejmuje pole
                        citiesEvolution.getMap().setOwnership(citiesRelation.getBest_x2(), citiesRelation.getBest_y2(), j + 1);
                    }

                } else {
                    if (citiesEvolution.getAdd1()) {
                        //miasto przejmuje pole
                        citiesEvolution.getMap().setOwnership(citiesEvolution.getBest_x1(), citiesEvolution.getBest_y1(), j + 1);
                    }
                    if(citiesRelation.getAdd2()){
                        //miasto przejmuje pole
                        citiesEvolution.getMap().setOwnership(citiesRelation.getBest_x2(), citiesRelation.getBest_y2(), j + 1);
                    }
                }

            }
        }
        //wyswietlenie mapy w konsoli
        //citiesEvolution.getMap().map_viewer(map_size);
    }
}


