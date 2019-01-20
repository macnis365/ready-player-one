package com.auto.app.com.auto.app.tools;

import java.util.HashSet;
import java.util.Set;

public class Backpack implements Inventory {
    private Set<Item> items;
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Backpack() {
        items = new HashSet<Item>();
    }

    @Override
    public void add(Item item) {
        items.add(item);
    }

    @Override
    public boolean remove(Item item) {
        return contains(item);
    }

    @Override
    public boolean contains(Item item) {
        if (items.contains(item)) {
            return items.remove(item);
        }
        return false;
    }

    @Override
    public String show() {
        return items.toString();
    }
}
