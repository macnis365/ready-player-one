package com.auto.app.game;

public class Item {
    private String name;
    private int points;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public static class ItemBuilder {
        private String name;
        private int points;

        public ItemBuilder() {

        }

        public ItemBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public ItemBuilder withPoints(int points) {
            this.points = points;
            return this;
        }

        public Item build() {
            Item item = new Item();
            item.name = this.name;
            item.points = this.points;
            return item;
        }
    }

    private Item() {

    }
}
