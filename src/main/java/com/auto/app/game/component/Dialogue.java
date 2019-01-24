package com.auto.app.game.component;

public class Dialogue {
    private String introduction;
    private String direction;

    private Dialogue() {
    }

    public String getIntroduction() {
        return introduction;
    }

    public String getDirection() {
        return direction;
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
