package com.auto.app.com.auto.app.characters;

import com.auto.app.com.auto.app.places.Location;
import com.auto.app.com.auto.app.tools.Backpack;
import com.auto.app.com.auto.app.tools.Item;

public class HumanPlayer implements Player, PlayerItemAction {

    private final String name;
    private Score score;
    private Backpack backpack;
    private Location currentLocation;
    private Backpack backPack;

    public HumanPlayer(String name) {
        this.name = name;
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

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    @Override
    public String examine(Item item) {
        return item.describe();
    }

    @Override
    public void collect(Item item) {
        this.backpack.add(item);
    }

    @Override
    public String lift(Item item) {
        return "You took the " + item.toString();
    }

    public String checkout() {
        return this.currentLocation.describeLocation();
    }

    public void setBackPack(Backpack backPack) {
        this.backPack = backPack;
    }
}
