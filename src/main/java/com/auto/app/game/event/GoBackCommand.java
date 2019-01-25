package com.auto.app.game.event;

import com.auto.app.game.component.Player;
import com.auto.app.game.util.Color;
import com.auto.app.game.util.ColorPrintStream;

public class GoBackCommand implements Command {
    private Player player;

    public GoBackCommand(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        player.setIsAlive(false);
        ColorPrintStream.printWithColor("Back to Main Menu.", Color.CYAN, Color.BLACK_BACKGROUND);
    }
}
