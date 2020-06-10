package Projekt;

import java.util.Random;

/**
 * Klasa odpowiadajaca za generowanie liczb pseudolosowych z wykorzystaniem ziarna (seed)
 */
public class RandomNumber {

    Random random;

    public RandomNumber(long seed) {
        random = new Random();
        random.setSeed(seed);      //ustawienie ziarna (seed)
    }

    /**
     *
     * @param range_random zakres liczb
     * @return zwraca liczbe pseudolosowa z podanego zakresu
     */
    public int getRandomNumber(int range_random) {

        return random.nextInt(range_random);

    }
}
