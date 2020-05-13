package Projekt;

import java.util.ArrayList;
import java.util.List;
class TurnSystem {


    MapContainer mapContainer;
    CitiesEvolution citiesEvolution;
    CitiesRelation citiesRelation;
    TurnValue turnValue;
   // MapGenerator mapGenerator;


    protected TurnSystem(int map_size, int number_cities,RandomNumber randomNumber) {
        mapContainer=new MapContainer(map_size);
        citiesEvolution = new CitiesEvolution(map_size, number_cities,randomNumber,mapContainer);
        citiesRelation = new CitiesRelation();
        turnValue = new TurnValue();
      //  mapGenerator = new MapGenerator(map_size,randomNumber);  //utworzeie mapy
    }

   /* protected void map_viewer(int map_size) //wersja deweloperska do sprawdzania mapy, potem się to wywali
    {
        for(int i=0;i<map_size;i++){
            for(int j=0;j<map_size;j++){
      System.out.print(mapGenerator.viewMap().get(i).get(j).getValue()+" ");
    } System.out.println();
        }}*/


    protected void simulationTurn(int map_size, int turn_number, int number_cities){
        mapContainer.getTestMap(map_size);
        for(int i = turn_number; i > 0; i--) {                              //Tura wszystkich miast
            for(int j = 0; j < number_cities; j++) {                       //Tura pojedynczego miasta
               citiesEvolution.getCity_table().get(j).addFortune(turnValue.countFieldValue(map_size, citiesEvolution.getCity_table().get(j).getCity_area(), citiesEvolution));
               // dodanie wartości wynikającej z posiadanych pól

                if(turnValue.checkCityUpgrade(citiesEvolution.getCity_table().get(j).getFortune(), citiesEvolution.getCity_table().get(j).getCity_level())){ //sprawdzenie czy może zlevelować
                    citiesEvolution.cityEvolution(map_size, j,mapContainer);
                }
            }//mapContainer.getMap(map_size); //wyswietla mape
            mapContainer.getTestMap(map_size);
        }
    }

}
