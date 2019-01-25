package com.auto.app.game.event;

import com.auto.app.game.component.Block;
import com.auto.app.game.component.Player;
import com.auto.app.game.util.Color;
import com.auto.app.game.util.ColorPrintStream;

public class EnterBlockCommand implements Command {
    private Player player;

    public EnterBlockCommand(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        Block currentBlock = player.getCurrentPosition();
        if (null != currentBlock.getNeighborBlocks() && currentBlock.getNeighborBlocks().isLocked()) {
            ColorPrintStream.printBackgroundColorWithNoMessage(Color.BLACK_BACKGROUND);
            ColorPrintStream.printWithColor("Room is locked.", Color.GREEN, Color.BLACK_BACKGROUND);
            ColorPrintStream.printBackgroundColorWithNoMessage(Color.BLACK_BACKGROUND);
        } else if (null != currentBlock.getNeighborBlocks()) {
            player.setCurrentPosition(currentBlock.getNeighborBlocks());
            ColorPrintStream.printBackgroundColorWithNoMessage(Color.BLACK_BACKGROUND, 2);
            ColorPrintStream.printWithColor(player.getCurrentPosition().getDialogue().getDirection(), Color.GREEN, Color.BLACK_BACKGROUND);
            ColorPrintStream.printWithColor(player.getCurrentPosition().getDialogue().getIntroduction(), Color.GREEN, Color.BLACK_BACKGROUND);
            ColorPrintStream.printBackgroundColorWithNoMessage(Color.BLACK_BACKGROUND, 2);
        } else {
            player.setHealth(0);
        }

    }
}
