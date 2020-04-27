package Projekt;

import java.util.Random;

abstract class RandomNumber {
    protected static int getRandomNumber(int range_random) {
        Random random = new Random();
        return random.nextInt(range_random);
    }
}
