package com.auto.app.com.auto.app.places;

import com.auto.app.com.auto.app.tools.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Room implements Location {
    private String name;
    private String description;
    private String ambience;
    List<Item> artifacts;
    private List<Room> connectingRooms;

    public Room (String name, String description){
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAmbience() {
        return ambience;
    }

    public void setAmbience(String ambience) {
        this.ambience = ambience;
    }

    public List<Item> getArtifacts() {
        return artifacts;
    }

    public void setArtifacts(List<Item> artifacts) {
        this.artifacts = artifacts;
    }

    public List<Room> getConnectingRooms() {
        return connectingRooms;
    }

    public void setConnectingRooms(List<Room> connectingRooms) {
        this.connectingRooms = connectingRooms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return Objects.equals(name, room.name) &&
                Objects.equals(description, room.description) &&
                Objects.equals(ambience, room.ambience) &&
                Objects.equals(artifacts, room.artifacts) &&
                Objects.equals(connectingRooms, room.connectingRooms);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, description, ambience, artifacts, connectingRooms);
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public List<Room> connectingRooms() {
        return connectingRooms;
    }

    @Override
    public String describeLocation() {
        return (null != ambience ? ambience+"\n" : "") + description;
    }

    @Override
    public Room goNorth() {
        return connectingRooms.get(1);
    }

    @Override
    public Room goSouth() {
        return connectingRooms.get(2);
    }

    @Override
    public Room goWest() {
        return connectingRooms.get(3);
    }

    @Override
    public Room goEast() {
        return connectingRooms.get(4);
    }
}
