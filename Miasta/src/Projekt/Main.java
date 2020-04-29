/*
Version 1.0.1
 */
package Projekt;

import java.util.Scanner;

abstract class Main {

    public static void main(String[] args) {

        int number_cities, map_size, turn_number;

        Scanner scan = new Scanner(System.in);

        System.out.println("Podaj liczbe miast:");
        number_cities = scan.nextInt();

        System.out.println("Podaj liczbe pol:"); //Narazie mapa jest kwadratowa, później można to zmienić w zależności jakie typ pola wybierzemy
        map_size = scan.nextInt();

        System.out.println("Podaj liczbe tur:");
        turn_number = scan.nextInt();


       TurnSystem turnSystem = new TurnSystem(map_size, number_cities);
       turnSystem.simulationTurn(turn_number, number_cities);

    }
}
