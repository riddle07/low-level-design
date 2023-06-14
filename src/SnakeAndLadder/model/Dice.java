package SnakeAndLadder.model;

import java.util.Random;

public class Dice {
    private int val;
    Random random;

    public Dice(int val) {
        random = new Random();
        this.val = val;
    }

    public int getVal() {
        return random.nextInt((val - 1) + 1) + 1;
    }
}