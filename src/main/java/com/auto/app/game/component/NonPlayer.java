package com.auto.app.game.component;

public class NonPlayer extends Character {
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

        public NpcPlayerBuilder buildWithName(String name) {
            this.name = name;
            return this;
        }

        public NpcPlayerBuilder buildWithIsThreatFlag(boolean isThreat) {
            this.isThreat = isThreat;
            return this;
        }

        public NpcPlayerBuilder buildWithPoints(int points) {
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