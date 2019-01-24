package com.auto.app.game.event;

import com.auto.app.game.Block;
import com.auto.app.game.Item;
import com.auto.app.game.Player;

public class CollectCommand implements Command {

    Player player;

    public CollectCommand(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        Block currentBlock = player.getCurrentPosition();
        Item item = currentBlock.getItems();
        if (null != item) {
            player.setItem(item);
            player.setScore(player.getScore() + item.getPoints());
            System.out.println("Item collected.");
        } else {
            System.out.println("No items to collect in here.");
        }
    }
}
