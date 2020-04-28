/*
Wersja Daniela
 */

package Projekt;

import java.util.Scanner;

abstract class Main {

    public static void main(String[] args) {

        int number_cities, map_size;

        Scanner scan = new Scanner(System.in);

       System.out.println("Podaj liczbe miast:");
        number_cities = scan.nextInt();

        System.out.println("Podaj liczbe pol:");
        map_size = scan.nextInt();


       TurnSystem turnSystem = new TurnSystem(map_size, number_cities);
       turnSystem.simulationTurn();

    }
}
