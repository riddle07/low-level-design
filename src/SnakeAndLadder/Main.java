package SnakeAndLadder;

import SnakeAndLadder.model.Levels;
import SnakeAndLadder.service.Play;

import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Levels levels = new Levels();
        int numberOfSnakes = sc.nextInt();
        while (numberOfSnakes > 0) {
            int startPosition = sc.nextInt();
            int endPosition = sc.nextInt();
            levels.setSnake(startPosition, endPosition);
            numberOfSnakes--;
        }
        int numberOfLadders = sc.nextInt();
        while (numberOfLadders > 0) {
            int startPosition = sc.nextInt();
            int endPosition = sc.nextInt();
            levels.setLadders(startPosition, endPosition);
            numberOfLadders--;
        }
        int numberOfPlayers = sc.nextInt();
        int index = 0;
        while (numberOfPlayers > 0) {
            String player = sc.next();
            levels.setPlayes(index, player);
            numberOfPlayers--;
            index++;
        }
        Play play = new Play(6);
        System.out.println(play.Simulate() + "wins the game");
    }
}
