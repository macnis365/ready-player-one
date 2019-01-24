package com.auto.app.game.component;

import java.io.Serializable;

public class NonPlayer extends Character implements Serializable {
    private static final long serialVersionUID = 8500992061792087696L;

    private boolean isThreat;
    private int points;

    public NonPlayer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getIsThreat() {
        return isThreat;
    }

    public void setIsThreat(boolean isThreat) {
        this.isThreat = isThreat;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public static class NpcPlayerBuilder {
        private String name;
        private boolean isThreat;
        private int points;

        public NpcPlayerBuilder() {

        }

        public NpcPlayerBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public NpcPlayerBuilder withIsThreatFlag(boolean isThreat) {
            this.isThreat = isThreat;
            return this;
        }

        public NpcPlayerBuilder withPoints(int points) {
            this.points = points;
            return this;
        }

        public NonPlayer build() {
            NonPlayer player = new NonPlayer();
            player.name = this.name;
            player.isThreat = this.isThreat;
            player.points = this.points;
            return player;
        }

    }
}
