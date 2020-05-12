package Projekt;

import java.util.Random;

public class RandomNumber{

    Random random;

public RandomNumber(long seed){
     random = new Random();
     random.setSeed(seed);      //ziarno do sprawdzania wersji ale nie wiem czy to tak może działać EDIT: może xD
}
    public int getRandomNumber(int range_random) {

        return random.nextInt(range_random);

    }
}
