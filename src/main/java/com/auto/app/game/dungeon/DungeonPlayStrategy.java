package com.auto.app.game.dungeon;

import com.auto.app.game.component.Player;
import com.auto.app.game.component.Theme;
import com.auto.app.game.event.*;
import com.auto.app.game.themestrategy.ThemePlayStrategy;
import com.auto.app.game.util.Color;
import com.auto.app.game.util.ColorPrintStream;
import com.auto.app.game.util.ScannerSingleton;

import java.util.HashMap;
import java.util.Map;

import static com.auto.app.game.util.Constants.INVALID_INPUT_ERROR_MESSAGE;

public class DungeonPlayStrategy implements ThemePlayStrategy {
    @Override
    public void play(Theme theme) {
        Player player = (Player) theme.getPlayer();
        Map<Integer, String> options = theme.getUserOptions();
        ColorPrintStream.printBackgroundColorWithNoMessage(Color.BLACK_BACKGROUND, 2);
        ColorPrintStream.printWithColor(player.getCurrentPosition().getDialogue().getDirection(), Color.GREEN, Color.BLACK_BACKGROUND);
        ColorPrintStream.printWithColor(player.getCurrentPosition().getDialogue().getIntroduction(), Color.GREEN, Color.BLACK_BACKGROUND);
        ColorPrintStream.printBackgroundColorWithNoMessage(Color.BLACK_BACKGROUND, 2);
        while (player.getIsAlive()) {
            for (HashMap.Entry action : options.entrySet()) {
                ColorPrintStream.printWithColor(action.getKey() + ". " + action.getValue(), Color.CYAN, Color.BLACK_BACKGROUND);
                ColorPrintStream.printBackgroundColorWithNoMessage(Color.BLACK_BACKGROUND);
            }
            ColorPrintStream.printBackgroundColorWithNoMessage(Color.BLACK_BACKGROUND);
            ColorPrintStream.printWithColor(">\t", Color.YELLOW, Color.BLACK_BACKGROUND);
            int userIntegerChoice;
            userIntegerChoice = ScannerSingleton.getIntegerInput();
            ColorPrintStream.printBackgroundColorWithNoMessage(Color.BLACK_BACKGROUND, 2);
            switch (userIntegerChoice) {
                case 8:
                    new EnterBlockCommand(player).execute();
                    break;
                case 1:
                    new CollectCommand(player).execute();
                    break;
                case 3:
                    player.setIsAlive(false);
                    break;
                case 5:
                    new KillCommand(player).execute();
                    break;
                case 2:
                    new SaveCommand(theme).execute();
                    break;
                default:
                    ColorPrintStream.printWithColor(INVALID_INPUT_ERROR_MESSAGE, Color.RED, Color.BLACK_BACKGROUND);
                    break;
            }
            if (player.getScore() > 30) {
                ColorPrintStream.printWithColor(player.name + " : wins the game with score " + theme.getWinScore(), Color.BLACK, Color.GREEN_BACKGROUND);
                ColorPrintStream.printBackgroundColorWithNoMessage(Color.BLACK_BACKGROUND, 2);
                ColorPrintStream.printWithColor("Going back to menu.", Color.GREEN, Color.BLACK_BACKGROUND);
                ColorPrintStream.printBackgroundColorWithNoMessage(Color.BLACK_BACKGROUND, 2);
                break;
            }
            if (player.getHealth() == 0) {
                ColorPrintStream.printBackgroundColorWithNoMessage(Color.BLACK_BACKGROUND, 2);
                ColorPrintStream.printWithColor(player.getName() + " killed! better luck next time", Color.RED, Color.BLACK_BACKGROUND);
                ColorPrintStream.printBackgroundColorWithNoMessage(Color.BLACK_BACKGROUND, 2);
                ColorPrintStream.printWithColor("Going back to menu.", Color.GREEN, Color.BLACK_BACKGROUND);
                ColorPrintStream.printBackgroundColorWithNoMessage(Color.BLACK_BACKGROUND, 2);
                break;
            }
        }
    }
}
