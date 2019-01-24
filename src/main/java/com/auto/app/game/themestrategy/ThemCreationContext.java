package com.auto.app.game.themestrategy;

import com.auto.app.game.component.Theme;

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
