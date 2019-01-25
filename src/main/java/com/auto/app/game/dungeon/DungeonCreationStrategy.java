package com.auto.app.game.dungeon;

import com.auto.app.game.component.*;
import com.auto.app.game.component.Character;
import com.auto.app.game.themestrategy.ThemeCreatoinStrategy;
import com.auto.app.game.util.Color;
import com.auto.app.game.util.ColorPrintStream;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static com.auto.app.game.dungeon.DungeonThemeConstants.*;

public class DungeonCreationStrategy implements ThemeCreatoinStrategy {

    @Override
    public Theme createTheme(Scanner input) {
        Character player = createPlayer(input);
        return new Theme.ThemeBuilder().buildWithName("Go Dungeon........").buildWithWinScore(10).buildWithPlayer(player).buildWithUserOptions(createUserOption()).build();
    }

    public Character createPlayer(Scanner input) {
        ColorPrintStream.printWithColor("Provide Your Character name", Color.GREEN, Color.BLACK_BACKGROUND);
        Player.PlayerBuilder playerBuilder = new Player.PlayerBuilder();
        playerBuilder.withName(input.next());
        Block rootBlock = createBlock(input);
        return playerBuilder.withHealth(100).withScore(0).withIsAlive(true).withCurrentPosition(rootBlock).build();
    }

    public Block createBlock(Scanner input) {
        Block.BlockBuilder blockBuilder = new Block.BlockBuilder();
        Block finalBlock = new Block.BlockBuilder().withName("3rd Room").withIsLocked(true).withDialogue(new Dialogue.DialogueBuilder().buildWithDirection(ROOM3_DIRECTION).buildWithIntroduction(ROOM3_INTRODUCTION).build()).build();
        Block secondBlock = new Block.BlockBuilder().withName("2 Room").withIsLocked(true).withNpcPlayers(new NonPlayer.NpcPlayerBuilder().withName("zombie").withIsThreatFlag(true).withPoints(10).build()).withNeighborBlocks(finalBlock).withDialogue(new Dialogue.DialogueBuilder().buildWithIntroduction(ROOM2_INTRODUCTION).buildWithDirection(ROOM2_DIRECTION).build()).build();
        return blockBuilder.withName("1 Room").withItem(new Item.ItemBuilder().withName("Skull").withPoints(10).withDescription(SKULL_DESCRIPTION).build()).withDialogue(new Dialogue.DialogueBuilder().buildWithIntroduction(ROOM1_INTRODUCTION).buildWithDirection(ROOM1_DIRECTION).build()).withNeighborBlocks(secondBlock).build();
    }

    public Map<Integer, String> createUserOption() {
        HashMap<Integer, String> options = new HashMap<>();
        options.put(8, "go to neighbor block.");
        options.put(1, "collect item in the block.");
        options.put(5, "kill the monster/zombie.");
        return options;
    }

}
