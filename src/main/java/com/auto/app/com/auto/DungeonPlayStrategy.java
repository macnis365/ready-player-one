package com.auto.app.com.auto.game.dungeon;

import com.auto.app.com.auto.game.Block;
import com.auto.app.com.auto.game.Player;
import com.auto.app.com.auto.game.Theme;
import com.auto.app.com.auto.game.event.CollectCommand;
import com.auto.app.com.auto.game.event.Command;
import com.auto.app.com.auto.game.event.EnterBlockCommand;
import com.auto.app.com.auto.game.event.KillCommand;
import com.auto.app.com.auto.game.themestrategy.ThemePlayStrategy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DungeonPlayStrategy implements ThemePlayStrategy {
    @Override
    public void play(Theme theme, Scanner input) {
        Player player = (Player) theme.getPlayer();
        Map<Integer, String> options = theme.getUserOptions();
        Command command = null;
        while (player.getIsAlive()) {
            Block playerCurrentPosition = player.getCurrentPosition();
            System.out.println(playerCurrentPosition.getStory());
            for (HashMap.Entry action : options.entrySet()) {
                System.out.println(action.getKey() + ". " + action.getValue());
            }
            int choice = input.nextInt();
            switch (choice) {
                case 8: // go neighbour block
                    command = new EnterBlockCommand(player);
                    break;
                case 1: // collect item
                    command = new CollectCommand(player);
                    break;
                case 3: // explore
                    break;
                case 5: // kill
                    command = new KillCommand(player);
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
            command.execute();
            if (player.getScore() > 20) {
                System.out.println(player.name + "wins the game with score " + theme.getWinScore());
                break;
            }
            if (player.getHealth() == 0) {
                System.out.println("Player one got killed! better luck next time");
                break;
            }
        }
    }
}
