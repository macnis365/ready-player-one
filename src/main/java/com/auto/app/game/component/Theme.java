package com.auto.app.game.component;

import com.auto.app.game.event.Command;

import java.util.List;
import java.util.Map;

public class Theme {

    private String name;
    private String descriptions;
    private int winScore;//win condition
    private Character player;
    private Map<Integer, String> userOptions;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWinScore() {
        return winScore;
    }

    public void setWinScore(int winScore) {
        this.winScore = winScore;
    }

    public Character getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Map<Integer, String> getUserOptions() {
        return userOptions;
    }

    public void setUserOptions(Map<Integer, String> userOptions) {
        this.userOptions = userOptions;
    }

    public static class ThemeBuilder {
        private String name;
        private int winScore;
        private Character player;
        private Map<Integer, String> userOptions;

        public ThemeBuilder() {
            Theme theme = new Theme();
        }

        public ThemeBuilder buildWithName(String name) {
            this.name = name;
            return this;
        }

        public ThemeBuilder buildWithWinScore(int winScore) {
            this.winScore = winScore;
            return this;
        }

        public ThemeBuilder buildWithPlayer(Character player) {
            this.player = player;
            return this;
        }

        public ThemeBuilder buildWithUserOptions(Map<Integer, String> userOptions) {
            this.userOptions = userOptions;
            return this;
        }

        public Theme build() {
            Theme theme = new Theme();
            theme.player = this.player;
            theme.winScore = this.winScore;
            theme.name = this.name;
            theme.userOptions = this.userOptions;
            return theme;
        }

    }
}
