package com.auto.app.game.dungeon;

import com.auto.app.game.*;
import com.auto.app.game.Character;
import com.auto.app.game.themestrategy.ThemeCreatoinStrategy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DungeonCreationStrategy implements ThemeCreatoinStrategy {
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
        Player player = playerBuilder.buildWithHealth(100).buildWithScore(0).buildWithisAlive(true).buildWithCurrentPosition(rootBlock).build();
        return player;
    }

    public Block createBlock(Scanner input) {
        Block.BlockBuilder blockBuilder = new Block.BlockBuilder();
        Block finalBlock = new Block.BlockBuilder().withName("3rd Room").withStory("You head off to the west\n" +
                "\n" +
                "You enter the room.\n" +
                "You see a set of stone steps leading to a wooden door, which is ajar. Light streams through the crack in the door.\n" +
                "The secret door leads back to the east.").build();
        Block secondBlock = new Block.BlockBuilder().withName("2 Room").withStory("You head off to the north\n" +
                "You are in a vast, dark hall.\n" +
                "There is a door to the south back to dungeon entrance.\n" +
                "A glowing orb floats in mid air,\n" +
                "In the center of the room on a raised platform there is a creature, looks dangerous.").withNpcPlayers(new NonPlayer.NpcPlayerBuilder().buildWithName("zombie").buildWithIsThreatFlag(true).buildWithPoints(20).build()).withNeighborBlocks(finalBlock).build();
        return blockBuilder.withName("1 Room").withStory("You Head off to Dungeon\n" +
                "The dungeon door slams shut behind you. \n" +
                "\n" +
                "you are in a maze of twisty little passage all alike\n" +
                "You see a dark doorway to the north, A human skull lies in the corner").withItem(new Item.ItemBuilder().withName("Skull").withPoints(20).buildWithDescription("The skull appears blackened and chared. It smell of sulfur.\n" + "You took the skull and added to your backpack.\n").build()).withNeighborBlocks(secondBlock).build();
    }

    public Map<Integer, String> createUserOption() {
        HashMap<Integer, String> options = new HashMap<>();
        options.put(8, "go to neighbor block.");
        options.put(1, "collect item in the block.");
        options.put(5, "kill the monster/zombie.");
        return options;
    }

}
