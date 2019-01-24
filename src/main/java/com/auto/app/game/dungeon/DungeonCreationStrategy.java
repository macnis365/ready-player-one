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
        Block endBlock = new Block.BlockBuilder().withName("2 Room").withStory("Love story").withItem(new Item.ItemBuilder().withName("Alter").withPoints(10).build()).withNpcPlayers(new NonPlayer.NpcPlayerBuilder().buildWithName("zombie").buildWithIsThreatFlag(true).buildWithPoints(20).build()).build();
        return blockBuilder.withName("1 Room").withStory("Horror Story").withItem(new Item.ItemBuilder().withName("Skull").withPoints(20).build()).withNeighborBlocks(endBlock).build();
    }

    public Map<Integer, String> createUserOption() {
        HashMap<Integer, String> options = new HashMap<>();
        options.put(8, "go to neighbor block.");
        options.put(1, "collect item in the block.");
        options.put(5, "kill the monster/zombie.");
        return options;
    }

}
