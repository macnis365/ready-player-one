package com.auto.app.game.component;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

public class Theme implements Serializable {
    private static final long serialVersionUID = 20L;

    private String name;
    private String descriptions;
    private Character player;
    private Map<Integer, String> userOptions;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        private Character player;
        private Map<Integer, String> userOptions;

        public ThemeBuilder() {
            Theme theme = new Theme();
        }

        public ThemeBuilder buildWithName(String name) {
            this.name = name;
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
            theme.name = this.name;
            theme.userOptions = this.userOptions;
            return theme;
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Theme)) return false;
        Theme theme = (Theme) o;
        return Objects.equals(name, theme.name) &&
                Objects.equals(descriptions, theme.descriptions) &&
                Objects.equals(player, theme.player) &&
                Objects.equals(userOptions, theme.userOptions);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, descriptions, player, userOptions);
    }
}
