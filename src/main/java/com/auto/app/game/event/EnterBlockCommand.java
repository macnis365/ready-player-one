package com.auto.app.game.event;

import com.auto.app.game.Block;
import com.auto.app.game.Player;

public class EnterBlockCommand implements Command {
    Player player;

    public EnterBlockCommand(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        Block currentBlock = player.getCurrentPosition();
        if (null != currentBlock.getNeighborBlocks() && currentBlock.getNeighborBlocks().isLocked()) {
            System.out.println();
            System.out.println("Room is locked.");
            System.out.println();
            return;
        } else if (null != currentBlock && null != currentBlock.getNeighborBlocks()) {
            player.setCurrentPosition(currentBlock.getNeighborBlocks());
            System.out.println();
            System.out.println();
            System.out.println(player.getCurrentPosition().getDialogue().getDirection());
            System.out.println(player.getCurrentPosition().getDialogue().getIntroduction());
            System.out.println();
        } else {
            player.setHealth(0);
        }

    }
}
