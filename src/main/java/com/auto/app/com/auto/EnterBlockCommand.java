package com.auto.app.com.auto.game.event;

import com.auto.app.com.auto.game.Block;
import com.auto.app.com.auto.game.Player;

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
            System.out.println("move to new room.");
        } else {
            player.setHealth(0);
        }

    }
}
