package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void register() {
        Game game = new Game();
        Player player = new Player(1, "User1", 100);
        game.register(player);

        Boolean expected = true;
        Boolean actual = game.findPlayerByName(player.getName()) != null;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void roundFirstStrengthThenSecond() throws NotRegisteredException {
        Game game = new Game();
        Player player = new Player(1, "User1", 200);
        game.register(player);
        Player player2 = new Player(2, "User2", 100);
        game.register(player2);

        int expected = 1;
        int actual = game.round(player.getName(), player2.getName());

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void roundFirstNotStrengthThenSecond() throws NotRegisteredException {
        Game game = new Game();
        Player player = new Player(1, "User1", 100);
        game.register(player);
        Player player2 = new Player(2, "User2", 200);
        game.register(player2);

        int expected = -1;
        int actual = game.round(player.getName(), player2.getName());

        Assertions.assertEquals(expected, actual);

    }

    @Test
    void roundStrengthEquals() throws NotRegisteredException {
        Game game = new Game();
        Player player = new Player(1, "User1", 100);
        game.register(player);
        Player player2 = new Player(2, "User2", 100);
        game.register(player2);

        int expected = 0;
        int actual = game.round(player.getName(), player2.getName());

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void roundNotRegisteredValidationForFirstPlayer() {
        Game game = new Game();
        Player existPlayer = new Player(1, "User1", 100);
        game.register(existPlayer);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> {
                    game.round("User2", existPlayer.getName());
                });
    }

    @Test
    void roundNotRegisteredValidationForSecondPlayer() {
        Game game = new Game();
        Player existPlayer = new Player(1, "User1", 100);
        game.register(existPlayer);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> {
                    game.round(existPlayer.getName(), "User2");
                });
    }

    @Test
    void findPlayerByNameFound() {
        Game game = new Game();
        Player player = new Player(1, "User1", 100);
        game.register(player);
        Player player2 = new Player(2, "User2", 100);
        game.register(player2);

        Boolean expected = true;
        Boolean actual = game.findPlayerByName(player2.getName()) != null;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void findPlayerByNameNotFound() {
        Game game = new Game();
        Player player = new Player(1, "User1", 100);
        game.register(player);

        Boolean expected = true;
        Boolean actual = game.findPlayerByName("User2") == null;

        Assertions.assertEquals(expected, actual);
    }
}