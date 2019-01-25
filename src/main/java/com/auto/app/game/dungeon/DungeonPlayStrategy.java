package com.auto.app.game.dungeon;

import com.auto.app.game.component.Player;
import com.auto.app.game.component.Theme;
import com.auto.app.game.event.*;
import com.auto.app.game.themestrategy.ThemePlayStrategy;
import com.auto.app.game.util.Color;
import com.auto.app.game.util.ColorPrintStream;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DungeonPlayStrategy implements ThemePlayStrategy {
    @Override
    public void play(Theme theme, Scanner input) {
        Player player = (Player) theme.getPlayer();
        Map<Integer, String> options = theme.getUserOptions();
        Command command = null;
        ColorPrintStream.printWithColor(player.getCurrentPosition().getDialogue().getDirection(), Color.GREEN, Color.BLACK_BACKGROUND);
        ColorPrintStream.printWithColor(player.getCurrentPosition().getDialogue().getIntroduction(), Color.GREEN, Color.BLACK_BACKGROUND);
        while (player.getIsAlive()) {
            for (HashMap.Entry action : options.entrySet()) {
                ColorPrintStream.printWithColor(action.getKey() + ". " + action.getValue(), Color.GREEN, Color.BLACK_BACKGROUND);
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
                case 2:// save game
                    command = new SaveCommand(theme);
                default:
                    ColorPrintStream.printWithColor("Invalid input", Color.GREEN, Color.BLACK_BACKGROUND);
                    break;
            }
//            null check
            command.execute();
            if (player.getScore() > 30) {
                ColorPrintStream.printWithColor(player.name + " : wins the game with score " + theme.getWinScore(), Color.GREEN, Color.BLACK_BACKGROUND);
                ColorPrintStream.printBackgroundColorWithNoMessage(Color.BLACK_BACKGROUND);
                ColorPrintStream.printBackgroundColorWithNoMessage(Color.BLACK_BACKGROUND);
                ColorPrintStream.printWithColor("Going back to menu.", Color.GREEN, Color.BLACK_BACKGROUND);
                ColorPrintStream.printBackgroundColorWithNoMessage(Color.BLACK_BACKGROUND);
                break;
            }
            if (player.getHealth() == 0) {
                ColorPrintStream.printWithColor("Player one got killed! better luck next time", Color.GREEN, Color.BLACK_BACKGROUND);
                ColorPrintStream.printBackgroundColorWithNoMessage(Color.BLACK_BACKGROUND);
                ColorPrintStream.printBackgroundColorWithNoMessage(Color.BLACK_BACKGROUND);
                ColorPrintStream.printWithColor("Going back to menu.", Color.GREEN, Color.BLACK_BACKGROUND);
                ColorPrintStream.printBackgroundColorWithNoMessage(Color.BLACK_BACKGROUND);
                break;
            }
        }
    }
}
