package com.auto.app.com.auto.app.characters;

public class HumanPlayer implements Player {

    private final String name;
    private Score score;

    public HumanPlayer(String name) {
        this.name = name;
        this.score = new Score();
    }
}
