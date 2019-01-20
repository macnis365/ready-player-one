package com.auto.app.com.auto.app.tools;

public class Utensil implements Item {
    private String color;
    private String name;
    private String description;
    private int point;

    public Utensil(String name, String description, int point) {
        this.name = name;
        this.description = description;
        this.point = point;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public String describe() {
        return this.description;
    }
}
