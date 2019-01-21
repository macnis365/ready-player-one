package com.auto.app.com.auto.app.characters;

import com.auto.app.com.auto.app.tools.Backpack;

public class HumanPlayerBuilder implements PlayerBuilder {
    private HumanPlayer player;

    public HumanPlayerBuilder(String name) {
        this.player = new HumanPlayer(name);
    }


    @Override
    public Player buildPlayerWithBackpack() {
        Backpack backpack = new Backpack();
        this.player.setBackPack(backpack);
        return player;
    }

    @Override
    public Player buildPlayerLocation() {

        return player;
    }

    @Override
    public Player buildPlayerScore() {
        Score score = new Score();
        score.setPoint(10);
        this.player.setScore(score);
        return player;
    }
}
