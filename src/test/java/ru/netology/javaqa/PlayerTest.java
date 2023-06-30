package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Objects;

class PlayerTest {
    @Test
    void getId() {
        Player player = new Player(1, "User1", 100);

        int actual = 1;
        int expected = player.getId();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getName() {
        Player player = new Player(1, "User1", 100);

        String actual = "User1";
        String expected = player.getName();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getStrength() {
        Player player = new Player(1, "User1", 100);

        int actual = 100;
        int expected = player.getStrength();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testEquals() {
        Player player = new Player(1, "User1", 100);

        Boolean expected = true;
        Boolean actual = player.equals(new Player(1, "User1", 100));

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testEqualsEqualNull() {
        Player player = new Player(1, "User1", 100);

        Boolean expected = false;
        Boolean actual = player.equals(null);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testEqualsEqualTheSame() {
        Player player = new Player(1, "User1", 100);

        Boolean expected = true;
        Boolean actual = player.equals(player);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testEqualsNotEqualAnotherClass() {
        Player player = new Player(1, "User1", 100);

        Boolean expected = false;
        Boolean actual = player.equals(new PlayerTest());

        Assertions.assertEquals(expected, actual);
    }


    @Test
    void testEqualsId() {
        Player player = new Player(1, "User1", 100);

        Boolean expected = false;
        Boolean actual = player.equals(new Player(2, "User1", 100));

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testEqualsName() {
        Player player = new Player(1, "User1", 100);

        Boolean expected = false;
        Boolean actual = player.equals(new Player(1, "User2", 100));

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testEqualsStrength() {
        Player player = new Player(1, "User1", 100);

        Boolean expected = false;
        Boolean actual = player.equals(new Player(1, "User1", 101));

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testHashCode() {
        Player player = new Player(1, "User1", 100);

        int expected = Objects.hash(player.getId(), player.getName(), player.getStrength());
        int actual = player.hashCode();

        Assertions.assertEquals(expected, actual);
    }
}