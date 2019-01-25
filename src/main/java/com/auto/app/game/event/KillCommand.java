package com.auto.app.game.event;

import com.auto.app.game.component.Block;
import com.auto.app.game.component.NonPlayer;
import com.auto.app.game.component.Player;
import com.auto.app.game.util.Color;
import com.auto.app.game.util.ColorPrintStream;

public class KillCommand implements Command {
    Player player;

    public KillCommand(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        Block currentBlock = player.getCurrentPosition();
        NonPlayer nonPlayer = currentBlock.getNonPlayers();
        if (null != nonPlayer && nonPlayer.getIsThreat()) {
            player.setScore(player.getScore() + nonPlayer.getPoints());
            currentBlock.setNonPlayers(null);
            if (null != player.getCurrentPosition().getNeighborBlocks()) {
                player.getCurrentPosition().getNeighborBlocks().setLocked(false);
                player.setExperience(player.getExperience() + 1);
            }
            ColorPrintStream.printBackgroundColorWithNoMessage(Color.BLACK_BACKGROUND);
            ColorPrintStream.printWithColor("Eliminated the threat.", Color.GREEN, Color.BLACK_BACKGROUND);
            ColorPrintStream.printBackgroundColorWithNoMessage(Color.BLACK_BACKGROUND, 2);
        } else {
            ColorPrintStream.printBackgroundColorWithNoMessage(Color.BLACK_BACKGROUND);
            ColorPrintStream.printWithColor("No threat to kill", Color.GREEN, Color.BLACK_BACKGROUND);
            ColorPrintStream.printBackgroundColorWithNoMessage(Color.BLACK_BACKGROUND);
        }
    }
}
