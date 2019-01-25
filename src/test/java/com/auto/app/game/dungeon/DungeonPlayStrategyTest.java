package com.auto.app.game.dungeon;

import com.auto.app.game.component.Block;
import com.auto.app.game.component.Dialogue;
import com.auto.app.game.component.Player;
import com.auto.app.game.component.Theme;
import com.auto.app.game.customexception.GameIllegalStateException;
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
public class DungeonPlayStrategyTest {
    DungeonPlayStrategy dungeonPlayStrategy;

    @Before
    public void setUp() {
        dungeonPlayStrategy = new DungeonPlayStrategy();
    }

    @Test
    @PrepareForTest(ScannerSingleton.class)
    public void testPlay() throws GameIllegalStateException {
        Theme theme = Mockito.mock(Theme.class);
        Player player = Mockito.mock(Player.class);
        Block block = Mockito.mock(Block.class);
        Dialogue dialogue = Mockito.mock(Dialogue.class);
        Mockito.when(player.getCurrentPosition()).thenReturn(block);
        Mockito.when(block.getDialogue()).thenReturn(dialogue);
        Mockito.when(theme.getPlayer()).thenReturn(player);
        Mockito.when(player.getIsAlive()).thenReturn(true);
        Mockito.when(player.getCurrentPosition().getDialogue().getDirection()).thenReturn("direction details");
        Mockito.when(player.getCurrentPosition().getDialogue().getIntroduction()).thenReturn("Block Introduction");
        PowerMockito.mockStatic(ScannerSingleton.class);
        Mockito.when(ScannerSingleton.getIntegerInput()).thenReturn(8);
        dungeonPlayStrategy.play(theme);
        Assert.assertNotNull(theme);
    }

    @Test
    @PrepareForTest(ScannerSingleton.class)
    public void testPlayWithKill() throws GameIllegalStateException {
        Theme theme = Mockito.mock(Theme.class);
        Player player = Mockito.mock(Player.class);
        Block block = Mockito.mock(Block.class);
        Dialogue dialogue = Mockito.mock(Dialogue.class);
        Mockito.when(player.getCurrentPosition()).thenReturn(block);
        Mockito.when(block.getDialogue()).thenReturn(dialogue);
        Mockito.when(theme.getPlayer()).thenReturn(player);
        Mockito.when(player.getIsAlive()).thenReturn(true);
        Mockito.when(player.getCurrentPosition().getDialogue().getDirection()).thenReturn("direction details");
        Mockito.when(player.getCurrentPosition().getDialogue().getIntroduction()).thenReturn("Block Introduction");
        PowerMockito.mockStatic(ScannerSingleton.class);
        Mockito.when(ScannerSingleton.getIntegerInput()).thenReturn(5);
        dungeonPlayStrategy.play(theme);
        Assert.assertNotNull(theme);
    }

    @Test
    @PrepareForTest(ScannerSingleton.class)
    public void testPlayCollectItem() throws GameIllegalStateException {
        Theme theme = Mockito.mock(Theme.class);
        Player player = Mockito.mock(Player.class);
        Block block = Mockito.mock(Block.class);
        Dialogue dialogue = Mockito.mock(Dialogue.class);
        Mockito.when(player.getCurrentPosition()).thenReturn(block);
        Mockito.when(block.getDialogue()).thenReturn(dialogue);
        Mockito.when(theme.getPlayer()).thenReturn(player);
        Mockito.when(player.getIsAlive()).thenReturn(true);
        Mockito.when(player.getCurrentPosition().getDialogue().getDirection()).thenReturn("direction details");
        Mockito.when(player.getCurrentPosition().getDialogue().getIntroduction()).thenReturn("Block Introduction");
        PowerMockito.mockStatic(ScannerSingleton.class);
        Mockito.when(ScannerSingleton.getIntegerInput()).thenReturn(1);
        dungeonPlayStrategy.play(theme);
        Assert.assertNotNull(theme);
    }
}