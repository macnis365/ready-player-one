package com.auto.app.game.component;

import java.io.Serializable;
import java.util.Objects;

public abstract class Character implements Serializable {

    public String name;
    public String aboutMe;
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

    public String getAboutMe() {
        return aboutMe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Character)) return false;
        Character character = (Character) o;
        return isAlive == character.isAlive &&
                Objects.equals(name, character.name) &&
                Objects.equals(aboutMe, character.aboutMe);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, aboutMe, isAlive);
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
}
