package SnakeAndLadder.service;

import SnakeAndLadder.model.Dice;
import SnakeAndLadder.model.Levels;
import SnakeAndLadder.model.Position;
import java.util.HashMap;

public class Play {
    HashMap<String, Position> playerHistory;
    HashMap<String, Integer> playerPosition;
    Levels levels;
    Dice dice;

    public Play(int n) {
        playerHistory = new HashMap<>();
        playerPosition = new HashMap<>();
        levels = Levels.getInstance();
        dice = new Dice(n);
    }

    private void initilizePlayersStartValue() {
        for (int i = 0; i < levels.getPlayers().size(); i++) {
            playerPosition.put(levels.getPlayers().get(i), 0);
        }
    }

    private boolean checkFordiceNumberGreaterThan100(int endPostion) {
        return endPostion <= 100;
    }

    private boolean hasPlayerWon(String player) {
        return playerPosition.get(player) == 100;
    }

    public String Simulate() {
        int i = -1;
        do {
            i++;
            if (i >= levels.getPlayers().size()) {
                i = 0;
            }
            StringBuilder str = new StringBuilder();
            String playerName = levels.getPlayers().get(i);
            str.append(str);
            int diceVal = dice.getVal();
            int endPosition = playerPosition.get(playerName) + diceVal;
            String sl = "";
            if (checkFordiceNumberGreaterThan100(endPosition)) {
                str.append(" rolled a ").append(diceVal);
                str.append(" and moved from ").append(playerPosition.get(playerName));
                if (levels.getSnakes().get(endPosition) != null) {
                    sl = " after Snake dinner";
                    playerPosition.put(playerName, levels.getSnakes().get(endPosition));
                } else {
                    if (levels.getLadders().get(endPosition) != null) {
                        sl = " after Ladder ride ";
                        playerPosition.put(playerName, levels.getLadders().get(endPosition));
                    } else {
                        playerPosition.put(playerName, endPosition);
                    }
                }
                str.append(" to ").append(playerPosition.get(playerName));
                str.append(sl);
            }
            System.out.println(str);
        } while (!hasPlayerWon(levels.getPlayers().get(i)));
        return levels.getPlayers().get(i);
    }
}
