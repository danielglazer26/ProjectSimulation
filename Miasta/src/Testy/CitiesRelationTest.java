package Testy;

import Projekt.CitiesEvolution;
import Projekt.CitiesRelation;
import Projekt.RandomNumber;
import Projekt.TurnValue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CitiesRelationTest {

    @Test/**Sprawdzanie czy dla agression_rate=0 miasta moga zabierac sobie pola (Nie powinny)*/
    void AddShouldBeFalse() {
        RandomNumber randomNumber=new RandomNumber(1);
        CitiesEvolution evolution = new CitiesEvolution(5,3,randomNumber);
        CitiesRelation relation = new CitiesRelation(10,0);
        evolution.getMap().setOwnership(0,1,2); //ustawienie aby miasta byly obok siebie
        evolution.getMap().setOwnership(0,2,2);
        evolution.getMap().map_viewer(5);
        for(int i=0;i<3;i++){
        relation.cityInfluence(0,5,3,i,evolution.getCity_table(),evolution.getMap());
        Assertions.assertFalse(relation.getAdd2());
    }}

    @Test/**Sprawdzenie czy dla agression_rate=1 miasta moga zabierac spbie pola (Powinny)*/
    void AddShouldBeTrueFalseFalse(){
        RandomNumber randomNumber=new RandomNumber(1);
        CitiesEvolution evolution = new CitiesEvolution(5,3,randomNumber);
        CitiesRelation relation = new CitiesRelation(10,1);
        evolution.getMap().setOwnership(0,1,2); //ustawienie aby miasta byly obok siebie
        evolution.getMap().setOwnership(0,2,2);

        evolution.getMap().setValue(0,1,15); //ustawienie aby miasto 2 mialo najwieksza wartosc
        evolution.getMap().setValue(0,2,15);
        evolution.getMap().setValue(0,0,15);
        evolution.getMap().setValue(0,3,5);
        evolution.getMap().setValue(0,4,5);
        evolution.getMap().map_viewer(5);
        //wartosci: 15,15,15,5 ,5
        //miasta:   2 ,2 ,2 ,3 ,1

        //dodanie wartosci pol miast
        for(int i=0;i<3;i++){evolution.getCity_table().get(i).addFortune(TurnValue.countFieldValue(5, i, evolution));}

            //sprawdzanie czy miasta moga zabrac pola

            //miasto 2 ma najwieksza wartosc = 45
            relation.cityInfluence(0,5,3,1,evolution.getCity_table(),evolution.getMap());
            Assertions.assertTrue(relation.getAdd2());

            //miasto 1 ma wartosc = 5
            relation.cityInfluence(0,5,3,0,evolution.getCity_table(),evolution.getMap());
            Assertions.assertFalse(relation.getAdd2());

            //miasto 3 ma wartosc = 5
            relation.cityInfluence(0,5,3,2,evolution.getCity_table(),evolution.getMap());
            Assertions.assertFalse(relation.getAdd2());

    }

}