package com.auto.app.com.auto.app.tools;

public class MedicalKit implements Item {
    private String name;

    @Override
    public String describe(String name) {
        return this.name + "give description";
    }

    @Override
    public String toString() {
        return "name";
    }
}
