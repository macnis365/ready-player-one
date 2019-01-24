package com.auto.app.game.dungeon;

import com.auto.app.game.component.*;
import com.auto.app.game.component.Character;
import com.auto.app.game.themestrategy.ThemeCreatoinStrategy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DungeonCreationStrategy implements ThemeCreatoinStrategy {

    public static final String ROOM1_INTRODUCTION = "you are in a maze of twisty little passage all alike\n" + "You see a dark doorway to the north, A human skull lies in the corner";
    public static final String SKULL_DESCRIPTION = "The skull appears blackened and chared. It smell of sulfur.\n" + "You took the skull and added to your backpack.\n";
    public static final String ROOM1_DIRECTION = "You Head off to Dungeon\n" + "The dungeon door slams shut behind you. \n";
    public static final String ROOM2_INTRODUCTION = "You are in a vast, dark hall.\n" +
            "There is a door to the south back to dungeon entrance.\n" +
            "A glowing orb floats in mid air,\n" +
            "In the center of the room on a raised platform there is a creature, looks dangerous.";
    public static final String ROOM2_DIRECTION = "You head off to the north\n";
    public static final String ROOM3_DIRECTION = "You head off to the west";
    public static final String ROOM3_INTRODUCTION = "You see a set of stone steps leading to a wooden door, which is ajar. Light streams through the crack in the door.\n" +
            "The secret door leads back to the east.";

    @Override
    public Theme createTheme(Scanner input) {
        Character player = createPlayer(input);
        Theme dungeon = new Theme.ThemeBuilder().buildWithName("Go Dungeon........").buildWithWinScore(10).buildWithPlayer(player).buildWithUserOptions(createUserOption()).build();
        return dungeon;
    }

    public Character createPlayer(Scanner input) {
        System.out.println("Character name");
        Player.PlayerBuilder playerBuilder = new Player.PlayerBuilder();
        playerBuilder.buildWithName(input.next());
        Block rootBlock = createBlock(input);
        Player player = playerBuilder.buildWithHealth(100).buildWithScore(0).withIsAlive(true).buildWithCurrentPosition(rootBlock).build();
        return player;
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
