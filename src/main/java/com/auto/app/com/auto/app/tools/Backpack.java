package com.auto.app.com.auto.app.tools;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Backpack implements Inventory {
    private String name;
    private Set<Item> items;
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Backpack(String name) {
        this.name = name;
        items = new HashSet<Item>();
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

    @Override
    public void add(Item item) {
        items.add(item);
    }

    @Override
    public boolean remove(Item item) {
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
