package com.auto.app.game.component;

public class Dialogue {
    private String introduction;
    private String direction;

    private Dialogue() {
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public static class DialogueBuilder {
        private String introduction;
        private String direction;

        public DialogueBuilder() {
        }

        public DialogueBuilder buildWithIntroduction(String introduction) {
            this.introduction = introduction;
            return this;
        }

        public DialogueBuilder buildWithDirection(String direction) {
            this.direction = direction;
            return this;
        }

        public Dialogue build() {
            Dialogue dialogue = new Dialogue();
            dialogue.direction = this.direction;
            dialogue.introduction = this.introduction;
            return dialogue;
        }
    }
}
