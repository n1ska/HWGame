package ru.netology.javaqa;

import jdk.jshell.spi.ExecutionControl;

import java.util.ArrayList;

public class Game {

    private ArrayList<Player> players = new ArrayList<Player>();

    public void register(Player player){
        players.add(player);
    }

    public int round(String playerName1, String playerName2) throws NotRegisteredException {
        Player player1 = findPlayerByName(playerName1);
        Player player2 = findPlayerByName(playerName2);

        if ((player1 == null) || (player2 == null))
            throw new NotRegisteredException("Player is not registered");

        if (player1.getStrength() > player2.getStrength())
            return 1;

        if (player1.getStrength() < player2.getStrength())
            return -1;

        return 0;
    }

    public Player findPlayerByName(String name){
        for (Player player : players){
            if (player.getName() == name)
                return player;
        }
        return null;
    }

}
