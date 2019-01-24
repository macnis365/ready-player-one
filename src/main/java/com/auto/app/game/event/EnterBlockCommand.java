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
        if (null != currentBlock && null != currentBlock.getNeighborBlocks()) {
            player.setCurrentPosition(currentBlock.getNeighborBlocks());
//            System.out.println("move to new room.");
            System.out.println(currentBlock.getDialogue().getIntroduction());
            System.out.println();
        } else {
            player.setHealth(0);
        }

    }
}
