package com.auto.app.game.event;

import com.auto.app.game.component.Block;
import com.auto.app.game.component.Item;
import com.auto.app.game.component.Player;

public class CollectCommand implements Command {

    Player player;

    public CollectCommand(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        Block currentBlock = player.getCurrentPosition();
        Item item = currentBlock.getItems();
        if (null != currentBlock.getNonPlayers() && currentBlock.getNonPlayers().getIsThreat()) {
            System.out.println("Creature kill you.");
            player.setHealth(0);
        } else if (null != item) {
            player.setItem(item);
            player.setScore(player.getScore() + item.getPoints());
            player.getCurrentPosition().getNeighborBlocks().setLocked(false);
            System.out.println(item.getDescription());
            System.out.println();
        } else {

            System.out.println("No items to collect in here.");
            System.out.println();

        }
    }
}
