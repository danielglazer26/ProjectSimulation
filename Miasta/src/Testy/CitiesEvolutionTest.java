package Testy;

import Projekt.CitiesEvolution;
import Projekt.RandomNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
class CitiesEvolutionTest {



    @Test
    /**Sprawdzenie czy algorytm wyboru najlepszego pola zadziala dla kazdego miasta*/
    void AddShouldBeTrue() {
        RandomNumber randomNumber=new RandomNumber(1);
        CitiesEvolution evolution = new CitiesEvolution(5,3,randomNumber);
        for(int i=0;i<3;i++) {
            evolution.cityEvolution(5, i);
            Assertions.assertTrue(evolution.getAdd1());
        }
    }

}