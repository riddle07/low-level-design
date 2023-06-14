package SnakeAndLadder.model;

import java.util.HashMap;

public class Levels {
    static HashMap<Integer, Integer> snakes;
    static HashMap<Integer, Integer> ladders;
    static HashMap<Integer, String> players;
    static Levels instance = null;

    public Levels() {
        snakes = new HashMap<>();
        ladders = new HashMap<>();
        players = new HashMap<>();
    }

    public void setSnake(int startPosition, int endPosition) {
        snakes.put(startPosition, endPosition);
    }

    public HashMap<Integer, Integer> getSnakes() {
        return snakes;
    }

    public void setLadders(int startPosition, int endPosition) {
        ladders.put(startPosition, endPosition);
    }

    public HashMap<Integer, Integer> getLadders() {
        return ladders;
    }

    public void setPlayes(int index, String playerName) {
        players.put(index, playerName);
    }

    public HashMap<Integer, String> getPlayers() {
        return players;
    }

    public static Levels getInstance() {
        if (instance == null) {
            instance = new Levels();
        }
        return instance;
    }
}
