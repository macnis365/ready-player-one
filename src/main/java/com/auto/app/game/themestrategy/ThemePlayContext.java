package com.auto.app.game.themestrategy;

import com.auto.app.game.component.Theme;
import com.auto.app.game.customexception.GameIllegalStateException;

public class ThemePlayContext {
    ThemePlayStrategy themePlayStrategy;

    public void setThemePlayStrategy(ThemePlayStrategy themePlayStrategy) {
        this.themePlayStrategy = themePlayStrategy;
    }

    public void play(Theme theme) throws GameIllegalStateException {
        themePlayStrategy.play(theme);
    }
}
