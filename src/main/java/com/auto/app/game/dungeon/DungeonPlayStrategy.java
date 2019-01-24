package com.auto.app.game.dungeon;

import com.auto.app.game.Block;
import com.auto.app.game.Player;
import com.auto.app.game.Theme;
import com.auto.app.game.event.CollectCommand;
import com.auto.app.game.event.Command;
import com.auto.app.game.event.EnterBlockCommand;
import com.auto.app.game.event.KillCommand;
import com.auto.app.game.themestrategy.ThemePlayStrategy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DungeonPlayStrategy implements ThemePlayStrategy {
    @Override
    public void play(Theme theme, Scanner input) {
        Player player = (Player) theme.getPlayer();
        Map<Integer, String> options = theme.getUserOptions();
        Command command = null;
        System.out.println(player.getCurrentPosition().getDialogue().getDirection());
        System.out.println(player.getCurrentPosition().getDialogue().getIntroduction());
        while (player.getIsAlive()) {
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
                System.out.println(player.name + " : wins the game with score " + theme.getWinScore());
                System.out.println();
                System.out.println("Going back to menu.");
                System.out.println();
                break;
            }
            if (player.getHealth() == 0) {
                System.out.println("Player one got killed! better luck next time");
                System.out.println();
                System.out.println("Going back to menu.");
                System.out.println();
                break;
            }
        }
    }
}
