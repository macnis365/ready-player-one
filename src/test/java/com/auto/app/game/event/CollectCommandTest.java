package com.auto.app.game.event;

import com.auto.app.game.component.Block;
import com.auto.app.game.component.Item;
import com.auto.app.game.component.NonPlayer;
import com.auto.app.game.component.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CollectCommandTest {
    Command command;
    Player player;

    @Before
    public void setUp() {
        Block block = new Block.BlockBuilder().withName("test room").withNpcPlayers(new NonPlayer.NpcPlayerBuilder().withName("mario").withIsThreatFlag(true).withPoints(10).build()).build();
        player = new Player.PlayerBuilder().withIsAlive(true).withCurrentPosition(block).withScore(0).withName("Dave").build();
        command = new CollectCommand(player);
    }

    @Test
    public void playerGetsKilledWhileCollectingItem() {
        command.execute();
        Assert.assertNotNull(player);
        Assert.assertEquals(0, player.getHealth());
    }

    @Test
    public void playerCollectsItem() {
        player.getCurrentPosition().setNonPlayers(null);
        player.getCurrentPosition().setItems(new Item.ItemBuilder().withName("Goblet").withPoints(20).withDescription("Goblet of fire").build());
        command.execute();
        Assert.assertNotNull(player);
        Assert.assertEquals(20, player.getScore());
        Assert.assertNotNull(player.getItem());
    }
}
