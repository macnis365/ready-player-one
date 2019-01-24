package com.auto.app;

import com.auto.app.game.component.Theme;
import com.auto.app.game.dungeon.DungeonCreationStrategy;
import com.auto.app.game.dungeon.DungeonPlayStrategy;
import com.auto.app.game.themestrategy.ThemCreationContext;
import com.auto.app.game.themestrategy.ThemePlayContext;

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
            System.out.println("List of Themes:");
            for (int index = 0; index < themes.size(); index++) {
                System.out.println(index + 1 + " - " + themes.get(index).getName());
            }
            int userChoice = scanner.nextInt();
            if (userChoice > 0 && themes.size() >= userChoice &&
                    "Dungeon and Dragon".equals(themes.get(userChoice - 1).getName())) {

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
        Theme theme1 = new Theme.ThemeBuilder().buildWithName("Dungeon and Dragon").build();
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
