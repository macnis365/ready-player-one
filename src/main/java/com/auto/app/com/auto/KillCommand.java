package com.auto.app.com.auto.game.event;

import com.auto.app.com.auto.game.Block;
import com.auto.app.com.auto.game.NonPlayer;
import com.auto.app.com.auto.game.Player;

public class KillCommand implements Command {
    Player player;

    public KillCommand(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        Block currentBlock = player.getCurrentPosition();
        NonPlayer nonPlayer = currentBlock.getNonPlayers();
        if (null != nonPlayer) {
//            remove threat from curentBlock, and add points to player
            currentBlock.setNonPlayers(null);
            System.out.println("Eleminated the threat.");
        } else {
            System.out.println("No threat to kill");
        }
    }
}
