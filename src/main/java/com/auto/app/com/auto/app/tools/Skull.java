package com.auto.app.com.auto.app.tools;

public class Skull implements Item {

    private String name;

    public Skull(String name) {
        this.name = name;
    }

    @Override
    public String describe(String name) {
        return "The " + this.name + " appears blackened and chared. It smell of sulfur.";
    }

    @Override
    public String toString() {
        return name;
    }
}
