/*
UWAGA !!!

*Program nie zawiera na razie żadnych zabezpieczeń przeciwko błednym danym
*Nie posiada na razie wersji okienkowej, która jest prawie skończona





 */
package Projekt;

import java.util.Scanner;

abstract class Main {

    public static void main(String[] args) {

        int number_cities, map_size, turn_number, seed;
        float agression_rate;

        Scanner scan = new Scanner(System.in);

        System.out.println("Podaj liczbe miast:");
        number_cities = scan.nextInt();

        System.out.println("Podaj liczbe pol:"); //Narazie mapa jest kwadratowa, później można to zmienić w zależności jakie typ pola wybierzemy
        map_size = scan.nextInt();

        System.out.println("Podaj liczbe tur:");
        turn_number = scan.nextInt();

        System.out.println("Podaj współczynnik agresji (0,1):");
        agression_rate = scan.nextFloat();

        System.out.println("Podaj seed:");
        seed = scan.nextInt();


        RandomNumber randomNumber = new RandomNumber(seed);
        TurnSystem turnSystem = new TurnSystem(turn_number, map_size, number_cities, agression_rate, randomNumber);
       // turnSystem.simulationTurn(map_size, turn_number, number_cities);

    }
}
