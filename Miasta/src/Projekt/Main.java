/*
Version 1.0.5
 */
package Projekt;

import java.util.Scanner;

abstract class Main {

    public static void main(String[] args) {

        int number_cities, map_size, turn_number, seed;

        Scanner scan = new Scanner(System.in);

        System.out.println("Podaj liczbe miast:");
        number_cities = scan.nextInt();

        System.out.println("Podaj liczbe pol:"); //Narazie mapa jest kwadratowa, później można to zmienić w zależności jakie typ pola wybierzemy
        map_size = scan.nextInt();

        System.out.println("Podaj liczbe tur:");
        turn_number = scan.nextInt();

        System.out.println("Podaj seed:");
        seed = scan.nextInt();


        RandomNumber randomNumber = new RandomNumber(seed);
        TurnSystem turnSystem = new TurnSystem(turn_number, map_size, number_cities, randomNumber);
        turnSystem.simulationTurn(map_size, turn_number, number_cities);

    }
}
