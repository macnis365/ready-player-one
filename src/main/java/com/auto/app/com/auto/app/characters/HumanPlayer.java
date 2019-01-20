package com.auto.app.com.auto.app.characters;

import com.auto.app.com.auto.app.places.Location;
import com.auto.app.com.auto.app.tools.Backpack;
import com.auto.app.com.auto.app.tools.Item;

public class HumanPlayer implements Player {

    private final String name;
    private Score score;
    private Backpack backpack;

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    private Location currentLocation;

    public HumanPlayer(String name) {
        this.name = name;
        this.score = new Score();
        backpack = new Backpack();
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

    @Override
    public String examine(Item item) {
        return item.describe();
    }

    public String checkout() {
        return this.currentLocation.describeLocation();
    }
}
