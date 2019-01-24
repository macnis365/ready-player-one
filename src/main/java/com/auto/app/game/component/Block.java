package com.auto.app.game.component;

import java.io.Serializable;

public class Block implements Serializable {
    private static final long serialVersionUID = 8496002061792087696L;

    private String name;
    private Block neighborBlocks;
    private Item items;
    private NonPlayer nonPlayers;
    private Dialogue dialogue;
    private boolean isLocked;

    private Block() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Block getNeighborBlocks() {
        return neighborBlocks;
    }

    public void setNeighborBlocks(Block neighborBlocks) {
        this.neighborBlocks = neighborBlocks;
    }

    public Item getItems() {
        return items;
    }

    public void setItems(Item items) {
        this.items = items;
    }

    public NonPlayer getNonPlayers() {
        return nonPlayers;
    }

    public void setNonPlayers(NonPlayer nonPlayers) {
        this.nonPlayers = nonPlayers;
    }

    public Dialogue getDialogue() {
        return dialogue;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    public static class BlockBuilder {
        private String name;
        private Block neighborBlocks;
        private Item items;
        private NonPlayer nonPlayers;
        private Dialogue dialogue;
        private boolean isLocked;

        public BlockBuilder() {

        }

        public BlockBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public BlockBuilder withNeighborBlocks(Block block) {
            this.neighborBlocks = block;
            return this;
        }

        public BlockBuilder withItem(Item item) {
            this.items = item;
            return this;
        }

        public BlockBuilder withNpcPlayers(NonPlayer nonPlayers) {
            this.nonPlayers = nonPlayers;
            return this;
        }

        public BlockBuilder withDialogue(Dialogue dialogue) {
            this.dialogue = dialogue;
            return this;
        }

        public BlockBuilder withIsLocked(boolean isLocked) {
            this.isLocked = isLocked;
            return this;
        }

        public Block build() {
            Block block = new Block();
            block.name = this.name;
            block.items = this.items;
            block.nonPlayers = this.nonPlayers;
            block.neighborBlocks = this.neighborBlocks;
            block.dialogue = this.dialogue;
            block.isLocked = this.isLocked;
            return block;
        }
    }
}
