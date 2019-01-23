package com.auto.app.com.auto.game.themestrategy;

import com.auto.app.com.auto.game.Theme;

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
