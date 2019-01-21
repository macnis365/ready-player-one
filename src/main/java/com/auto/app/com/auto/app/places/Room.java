package com.auto.app.com.auto.app.places;

import com.auto.app.com.auto.app.tools.Item;
import com.auto.app.com.auto.app.tools.Utensil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Room implements Location {
    private String name;
    private String description;
    private String ambience;

    List<Item> artifacts;
    private Room nextRoom;
    private Room previousRoom;

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        this.artifacts = new ArrayList<>();
    }

    public Room(String name, String ambience, String description) {
        this.name = name;
        this.ambience = ambience;
        this.description = description;
        this.artifacts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getArtifacts() {
        return artifacts;
    }

    public void setArtifacts(List<Item> artifacts) {
        this.artifacts = artifacts;
    }

    public Room getNextRoom() {
        return nextRoom;
    }

    public void setNextRoom(Room nextRoom) {
        this.nextRoom = nextRoom;
    }

    public Room getPreviousRoom() {
        return previousRoom;
    }

    public void setPreviousRoom(Room previousRoom) {
        this.previousRoom = previousRoom;
    }

    @Override
    public String describeLocation() {
        return (null != ambience ? ambience + "\n" : "") + description;
    }

    public String itemListOption() {
        StringBuilder builder = new StringBuilder();
        for (Item item : artifacts) {
            int i = 1;
            Utensil utensil = (Utensil) item;
            builder.append(1).append(" - ").append(utensil.getName()).append("\n");
        }
        return builder.toString();
    }

    public String roomOptions() {
        StringBuilder builder = new StringBuilder();
        if(null != nextRoom){
            builder.append("1. go to next room").append("\n").append("2. back to provious room");
        }

        return builder.toString();
    }

    @Override
    public String toString() {
        return name;
    }


}
