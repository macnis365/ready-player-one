package com.auto.app.game.component;


import java.io.Serializable;
import java.util.Objects;

public class Player extends Character implements Serializable {
    private static final long serialVersionUID = 10L;
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

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public static class PlayerBuilder {
        private String name;
        private int health;
        private int score;
        private Block currentPosition;
        private Item item;
        private String aboutMe;
        private boolean isAlive;

        public PlayerBuilder() {

        }

        public PlayerBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public PlayerBuilder withHealth(int health) {
            this.health = health;
            return this;
        }

        public PlayerBuilder withScore(int score) {
            this.score = score;
            return this;
        }

        public PlayerBuilder withCurrentPosition(Block block) {
            this.currentPosition = block;
            return this;
        }

        public PlayerBuilder withAboutMe(String aboutMe) {
            this.aboutMe = aboutMe;
            return this;
        }

        public PlayerBuilder withItem(Item item) {
            this.item = item;
            return this;
        }

        public PlayerBuilder withIsAlive(boolean alive) {
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
            player.aboutMe = this.aboutMe;
            return player;
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player)) return false;
        if (!super.equals(o)) return false;
        Player player = (Player) o;
        return score == player.score &&
                health == player.health &&
                experience == player.experience &&
                Objects.equals(currentPosition, player.currentPosition) &&
                Objects.equals(item, player.item);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), score, health, currentPosition, item, experience);
    }
}
