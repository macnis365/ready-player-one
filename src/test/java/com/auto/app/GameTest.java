package com.auto.app;

import com.auto.app.com.auto.app.Game;
import com.auto.app.com.auto.app.characters.HumanPlayer;
import com.auto.app.com.auto.app.places.Room;
import org.junit.Test;

public class GameTest {

    @Test
    public void createGameTest() {
        HumanPlayer player = new HumanPlayer("Dummy player");
        Game.createGame(player);
        Room room = (Room) player.getCurrentLocation();
        do {
            System.out.println(room.describeLocation());
            room = room.getNextRoom();
            player.setCurrentLocation(room);
            System.out.println("");
        } while (room != null);
    }
}
