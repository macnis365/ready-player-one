package com.auto.app.game.event;

import com.auto.app.game.component.*;
import org.junit.Before;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URLDecoder;
import java.util.HashMap;

import static com.auto.app.game.dungeon.DungeonThemeConstants.*;

public class SaveCommandTest {
    Command command;
    Theme theme;

    @Before
    public void setUp() {
        Block.BlockBuilder blockBuilder = new Block.BlockBuilder();
        Block finalBlock = new Block.BlockBuilder().withName("3rd Room").withIsLocked(true).withDialogue(new Dialogue.DialogueBuilder().buildWithDirection(ROOM3_DIRECTION).buildWithIntroduction(ROOM3_INTRODUCTION).build()).build();
        Block secondBlock = new Block.BlockBuilder().withName("2 Room").withIsLocked(true).withNpcPlayers(new NonPlayer.NpcPlayerBuilder().withName("zombie").withIsThreatFlag(true).withPoints(10).build()).withNeighborBlocks(finalBlock).withDialogue(new Dialogue.DialogueBuilder().buildWithIntroduction(ROOM2_INTRODUCTION).buildWithDirection(ROOM2_DIRECTION).build()).build();
        Block rootBlock = blockBuilder.withName("1 Room").withItem(new Item.ItemBuilder().withName("Skull").withPoints(10).withDescription(SKULL_DESCRIPTION).build()).withDialogue(new Dialogue.DialogueBuilder().buildWithIntroduction(ROOM1_INTRODUCTION).buildWithDirection(ROOM1_DIRECTION).build()).withNeighborBlocks(secondBlock).build();

        Player player = new Player.PlayerBuilder().withCurrentPosition(rootBlock).withScore(0).withHealth(100).withName("Dave").withIsAlive(true).build();

        HashMap<Integer, String> options = new HashMap<>();
        options.put(8, "go to neighbor block.");
        options.put(1, "collect item in the block.");
        options.put(5, "kill the monster/zombie.");
        theme = new Theme.ThemeBuilder().buildWithName("dungeon and dragon").buildWithUserOptions(options).buildWithPlayer(player).build();
        command = new SaveCommand(theme);
    }

    @Test
    public void testExecute() {
        command.execute();
    }
}
