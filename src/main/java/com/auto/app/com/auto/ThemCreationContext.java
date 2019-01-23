package com.auto.app.com.auto.game.themestrategy;

import com.auto.app.com.auto.game.Theme;

import java.util.Scanner;

public class ThemCreationContext {
    ThemeCreatoinStrategy themeCreatoinStrategy;

    public void setThemeCreatoinStrategy(ThemeCreatoinStrategy themeCreatoinStrategy) {
        this.themeCreatoinStrategy = themeCreatoinStrategy;
    }

    public Theme createTheme(Scanner scanner) {
        return themeCreatoinStrategy.createTheme(scanner);
    }
}
