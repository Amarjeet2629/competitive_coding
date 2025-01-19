package org.cp.LLD.snakeAndLadder.entity;

import java.util.Random;

public class Dice implements IDice{
    private final int numberOfSides;
    private final Random random = new Random();

    public Dice(int numberOfSides){
        this.numberOfSides = numberOfSides;
    }

    public int rollDice(){
        return random.nextInt(1, numberOfSides + 1);
    }
}
