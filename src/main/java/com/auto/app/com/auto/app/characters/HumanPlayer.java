package com.auto.app.com.auto.app.characters;

import com.auto.app.com.auto.app.tools.Backpack;
import com.auto.app.com.auto.app.tools.Item;

import java.util.Collection;
import java.util.Collections;

public class HumanPlayer implements Player {

    private final String name;
    private Score score;
    private Backpack backpack;

    public HumanPlayer(String name) {
        this.name = name;
        this.score = new Score();
        backpack = new Backpack("backpack");
    }

    public String getName() {
        return name;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public Backpack getBackpack() {
        return backpack;
    }

    public void setBackpack(Backpack backpack) {
        this.backpack = backpack;
    }

    public String examine(Collection<Item> item) {
        return "";
    }
}
