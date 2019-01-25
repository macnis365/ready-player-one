package com.auto.app.game.themestrategy;

import com.auto.app.game.component.Theme;

public class ThemCreationContext {
    ThemeCreatoinStrategy themeCreatoinStrategy;

    public void setThemeCreatoinStrategy(ThemeCreatoinStrategy themeCreatoinStrategy) {
        this.themeCreatoinStrategy = themeCreatoinStrategy;
    }

    public Theme createTheme() {
        return themeCreatoinStrategy.createTheme();
    }
}
