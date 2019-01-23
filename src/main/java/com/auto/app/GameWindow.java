package com.auto.app;

import com.auto.app.com.auto.game.Theme;
import com.auto.app.com.auto.game.dungeon.DungeonCreationStrategy;
import com.auto.app.com.auto.game.dungeon.DungeonPlayStrategy;
import com.auto.app.com.auto.game.themestrategy.ThemCreationContext;
import com.auto.app.com.auto.game.themestrategy.ThemePlayContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameWindow {

    List<Theme> themes = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        GameWindow gameWindow = new GameWindow();
        gameWindow.initializeTheme();
    }

    public void initializeTheme() {
        boolean themeStart;
        System.out.println("========================Game Window=================================");
        themeStart = true;
        themes = loadTheme();
        while (themeStart) {
            for (int index = 0; index < themes.size(); index++) {
                System.out.println("List of Themes:");
                System.out.println(index + 1 + " - " + themes.get(index).getName());
            }
            System.out.println("Please choose any:");
            int userChoice = scanner.nextInt();
            Theme userChoosenTheme = themes.get(userChoice - 1);
            System.out.println("Choose options ");
            System.out.println("1. To Create your character");
            System.out.println("2. load game");
            int choice = scanner.nextInt();

            if ("Dungeon and Dragaon".equals(userChoosenTheme.getName())) {
                ThemCreationContext context = new ThemCreationContext();
                context.setThemeCreatoinStrategy(new DungeonCreationStrategy());
                Theme dungeonTheme = context.createTheme(scanner);
                ThemePlayContext themePlayContext = new ThemePlayContext();
                themePlayContext.setThemePlayStrategy(new DungeonPlayStrategy());
                themePlayContext.play(dungeonTheme, scanner);
            } else {
//                Mario
                themeStart = false;
            }
//            set themeStart false to end game
        }
        System.out.println("==============================End====================================");
    }

    public List<Theme> loadTheme() {
        Theme theme1 = new Theme.ThemeBuilder().buildWithName("Dungeon and Dragaon").build();
        Theme theme2 = new Theme.ThemeBuilder().buildWithName("Super Mario").build();
        themes.add(theme1);
        themes.add(theme2);
        return themes;
    }

    public void start() {
        initializeTheme();
    }

    public void restart() {
        initializeTheme();
    }
}
