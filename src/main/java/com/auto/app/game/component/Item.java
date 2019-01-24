package com.auto.app.game.component;

import java.io.Serializable;

public class Item implements Serializable {
    private static final long serialVersionUID = 2L;

    private String name;
    private String description;
    private int points;

    private Item() {

    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static class ItemBuilder {
        private String name;
        private int points;
        private String description;

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

        public ItemBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        public Item build() {
            Item item = new Item();
            item.name = this.name;
            item.points = this.points;
            item.description = this.description;
            return item;
        }
    }
}
