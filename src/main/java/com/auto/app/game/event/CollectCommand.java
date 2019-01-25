package com.auto.app.game.event;

import com.auto.app.game.component.Block;
import com.auto.app.game.component.Item;
import com.auto.app.game.component.Player;
import com.auto.app.game.util.Color;
import com.auto.app.game.util.ColorPrintStream;

public class CollectCommand implements Command {

    private Player player;

    public CollectCommand(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        Block currentBlock = player.getCurrentPosition();
        Item item = currentBlock.getItems();
        if (null != currentBlock.getNonPlayers() && currentBlock.getNonPlayers().getIsThreat()) {
            ColorPrintStream.printWithColor("Creature killed you.", Color.GREEN, Color.BLACK_BACKGROUND);
            player.setHealth(0);
        } else if (null != item) {
            player.setItem(item);
            player.setScore(player.getScore() + item.getPoints());
            currentBlock.setItems(null);
            if (null != player.getCurrentPosition().getNeighborBlocks()) {
                player.getCurrentPosition().getNeighborBlocks().setLocked(false);
            }
            ColorPrintStream.printWithColor(item.getDescription(), Color.GREEN, Color.BLACK_BACKGROUND);
            ColorPrintStream.printBackgroundColorWithNoMessage(Color.BLACK_BACKGROUND);
        } else {
            ColorPrintStream.printWithColor("No items to collect in here.", Color.GREEN, Color.BLACK_BACKGROUND);
            ColorPrintStream.printBackgroundColorWithNoMessage(Color.BLACK_BACKGROUND);
        }
    }
}
