package com.auto.app.game.event;

import com.auto.app.game.component.Block;
import com.auto.app.game.component.NonPlayer;
import com.auto.app.game.component.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class KillCommandTest {
    Command command;
    Player player;

    @Before
    public void setUp() {
        Block block = new Block.BlockBuilder().withName("test room").withNpcPlayers(new NonPlayer.NpcPlayerBuilder().buildWithName("mario").buildWithIsThreatFlag(true).buildWithPoints(10).build()).build();
        player = new Player.PlayerBuilder().buildWithisAlive(true).buildWithCurrentPosition(block).buildWithScore(0).buildWithName("Dave").build();
        command = new KillCommand(player);
    }

    @Test
    public void killMonsterFromTheBlock() {
        command.execute();
        Assert.assertNotNull(player);
        Assert.assertNotNull(player.getCurrentPosition());
        Assert.assertEquals("Player score changes after killing the monster", 10, player.getScore());
        Assert.assertNull(player.getCurrentPosition().getNonPlayers());
    }

    @Test
    public void tryKillWithoutMonsterInTheBlock() {
        player.getCurrentPosition().setNonPlayers(null);
        command.execute();
        Assert.assertEquals("Player score remains same after killing the monster", 0, player.getScore());
        Assert.assertNull(player.getCurrentPosition().getNonPlayers());
    }
}
