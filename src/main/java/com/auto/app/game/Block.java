package com.auto.app.game;

public class Block {

    private String name;
    private Block neighborBlocks;
    private Item items;
    private NonPlayer nonPlayers;
    private String story;


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

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public static class BlockBuilder {
        private String name;
        private Block neighborBlocks;
        private Item items;
        private NonPlayer nonPlayers;
        private String story;

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

        public BlockBuilder withStory(String story) {
            this.story = story;
            return this;
        }

        public Block build() {
            Block block = new Block();
            block.name = this.name;
            block.items = this.items;
            block.nonPlayers = this.nonPlayers;
            block.neighborBlocks = this.neighborBlocks;
            block.story = this.story;
            return block;
        }
    }
}
