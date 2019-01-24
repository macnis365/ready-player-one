package com.auto.app.game.component;

import java.io.Serializable;

public abstract class Character implements Serializable {

    public String name;
    public boolean isAlive;

    protected Character() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
}
