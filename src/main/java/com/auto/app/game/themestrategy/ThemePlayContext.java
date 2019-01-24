package com.auto.app.game.themestrategy;

import com.auto.app.game.component.Theme;

import java.util.Scanner;

public class ThemePlayContext {
    ThemePlayStrategy themePlayStrategy;

    public void setThemePlayStrategy(ThemePlayStrategy themePlayStrategy) {
        this.themePlayStrategy = themePlayStrategy;
    }

    public void play(Theme theme, Scanner scanner) {
        themePlayStrategy.play(theme, scanner);
    }
}
