package ru.netology.javaqa;

import jdk.jshell.spi.ExecutionControl;

import java.util.ArrayList;
import java.util.HashMap;

public class Game {

    private HashMap<String, Player> players = new HashMap<String, Player>();

    public void register(Player player) {
        players.put(player.getName(), player);
    }

    public int round(String playerName1, String playerName2) throws NotRegisteredException {
        Player player1 = findPlayerByNameOrNull(playerName1);
        Player player2 = findPlayerByNameOrNull(playerName2);

        if ((player1 == null) || (player2 == null))
            throw new NotRegisteredException("Player is not registered");

        if (player1.getStrength() > player2.getStrength())
            return 1;

        if (player1.getStrength() < player2.getStrength())
            return -1;

        return 0;
    }

    public Player findPlayerByNameOrNull(String name) {
        return players.get(name);
    }

}
