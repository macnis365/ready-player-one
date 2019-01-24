package com.auto.app.game.event;

import com.auto.app.game.component.Block;
import com.auto.app.game.component.NonPlayer;
import com.auto.app.game.component.Player;

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
            }
            System.out.println("Eliminated the threat.");
        } else {
            System.out.println("No threat to kill");
        }
    }
}
