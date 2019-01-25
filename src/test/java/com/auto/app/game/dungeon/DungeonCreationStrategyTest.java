package com.auto.app.game.dungeon;

import com.auto.app.game.component.Block;
import com.auto.app.game.component.Character;
import com.auto.app.game.component.Player;
import com.auto.app.game.component.Theme;
import com.auto.app.game.util.ScannerSingleton;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
public class DungeonCreationStrategyTest {
    DungeonCreationStrategy dungeonCreationStrategy;

    @Before
    public void setUp() {
        dungeonCreationStrategy = new DungeonCreationStrategy();
    }

    @Test
    public void createBlockTest() {
        Block block = dungeonCreationStrategy.createBlock();
        blockOne(block);
        blockTwo(block.getNeighborBlocks());
        blockThree(block.getNeighborBlocks().getNeighborBlocks());
    }

    private void blockThree(Block block) {
        Assert.assertNotNull(block);
        Assert.assertNull(block.getNonPlayers());
        Assert.assertNotNull(block.getDialogue());
        Assert.assertNull(block.getItems());
        Assert.assertEquals(true, block.isLocked());
        Assert.assertEquals("Chapter 3", block.getName());
    }

    private void blockTwo(Block block) {
        Assert.assertNotNull(block);
        Assert.assertNotNull(block.getNonPlayers());
        Assert.assertNotNull(block.getDialogue());
        Assert.assertNull(block.getItems());
        Assert.assertEquals(true, block.isLocked());
        Assert.assertEquals("Chapter 2", block.getName());
    }

    private void blockOne(Block block) {
        Assert.assertNotNull(block);
        Assert.assertNull(block.getNonPlayers());
        Assert.assertNotNull(block.getDialogue());
        Assert.assertNotNull(block.getItems());
        Assert.assertEquals(false, block.isLocked());
        Assert.assertEquals("Chapter 1", block.getName());
    }

    @Test
    @PrepareForTest(ScannerSingleton.class)
    public void createThemeTest() {
        PowerMockito.mockStatic(ScannerSingleton.class);
        Mockito.when(ScannerSingleton.getStringInput()).thenReturn("Dummy Player");
        Theme theme = dungeonCreationStrategy.createTheme();
        Assert.assertNotNull(theme);
        Assert.assertNotNull(theme.getPlayer());

        Assert.assertEquals("Dummy Player", theme.getPlayer().getName());
    }

    @Test
    @PrepareForTest(ScannerSingleton.class)
    public void createPlayerTest() {
        PowerMockito.mockStatic(ScannerSingleton.class);
        Mockito.when(ScannerSingleton.getStringInput()).thenReturn("DWade");
        Character character = dungeonCreationStrategy.createPlayer();
        Player player = (Player) character;
        Assert.assertNotNull(player);
        Assert.assertEquals("DWade", player.getName());
        Assert.assertEquals(true, player.getIsAlive());
        Assert.assertEquals(0, player.getScore());
    }

}
