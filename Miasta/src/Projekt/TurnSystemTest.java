package Projekt;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TurnSystemTest {

    @Test/**Sprawdzenie czy dziala algorytm zabrania pola innym miastom*/
    void TurnSystemCheck() {
        RandomNumber randomNumber=new RandomNumber(1);
        TurnSystem turnSystem = new TurnSystem(3,5,3,1,randomNumber);

        turnSystem.citiesEvolution.getMap().setOwnership(0,1,2); //ustawienie aby miasta byly obok siebie
        turnSystem.citiesEvolution.getMap().setOwnership(0,2,2);

        turnSystem.citiesEvolution.getMap().setValue(0,1,15); //ustawienie aby miasto 2 mialo najwieksza wartosc
        turnSystem.citiesEvolution.getMap().setValue(0,2,15);
        turnSystem.citiesEvolution.getMap().setValue(0,0,15);
        turnSystem.citiesEvolution.getMap().setValue(0,3,5);
        turnSystem.citiesEvolution.getMap().setValue(0,4,5);

        //ustawienie aby miasta zawsze wybieraly pola z x=0
        for(int i=0;i<5;i++) {turnSystem.citiesEvolution.getMap().setValue(1,i,0);}
        turnSystem.citiesEvolution.getMap().map_viewer(5);
        //wartosci(x=0): 15,15,15,5 ,5
        //wartosci(x=1): 0 ,0 ,0 ,0 ,0

        //miasta:   2 ,2 ,2 ,3 ,1

        //przeprowadzamy 11 tur //(11*45)>468=wartosc ktora musi osiagnac misto z 3 polami aby moc zabrac kolejne pole
        for(int i=0;i<19;i++){ turnSystem.simulationTurn(i,5,3); turnSystem.citiesEvolution.getMap().map_viewer(5);}

        //teraz miasto nr.2 powinno posiadac pole (0,3)
        Assertions.assertEquals(2,turnSystem.citiesEvolution.getMap().getOwnership(0,3));

        //przeprowadzamy dodatkowe 8 tur //(19*45+8*5)>wartosc ktora musi osiagnac misto z 4 polami aby moc zabrac kolejne pole
        for(int i=0;i<8;i++){ turnSystem.simulationTurn(i,5,3); turnSystem.citiesEvolution.getMap().map_viewer(5);}

        //teraz miasto nr.2 powinno posiadac pole (0,4)
        Assertions.assertEquals(2,turnSystem.citiesEvolution.getMap().getOwnership(0,4));

    }
}