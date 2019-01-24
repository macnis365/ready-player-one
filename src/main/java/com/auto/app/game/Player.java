package com.auto.app.game;


public class Player extends Character {

    private int score;
    private int health;
    private Block currentPosition;
    private Item item;
    private int experience;

    public Player() {
    }


    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Block getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(Block currentPosition) {
        this.currentPosition = currentPosition;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public boolean getIsAlive() {
        return this.isAlive;
    }

    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public static class PlayerBuilder {
        private String name;
        private int health;
        private int score;
        private Block currentPosition;
        private Item item;
        private boolean isAlive;

        public PlayerBuilder() {

        }

        public PlayerBuilder buildWithName(String name) {
            this.name = name;
            return this;
        }

        public PlayerBuilder buildWithHealth(int health) {
            this.health = health;
            return this;
        }

        public PlayerBuilder buildWithScore(int score) {
            this.score = score;
            return this;
        }

        public PlayerBuilder buildWithCurrentPosition(Block block) {
            this.currentPosition = block;
            return this;
        }

        public PlayerBuilder buildWithItem(Item item) {
            this.item = item;
            return this;
        }

        public PlayerBuilder buildWithisAlive(boolean alive) {
            this.isAlive = alive;
            return this;
        }

        public Player build() {
            Player player = new Player();
            player.name = this.name;
            player.score = this.score;
            player.item = this.item;
            player.currentPosition = this.currentPosition;
            player.health = this.health;
            player.isAlive = this.isAlive;
            return player;
        }

    }
}