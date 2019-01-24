package com.auto.app;

import com.auto.app.game.component.Theme;
import com.auto.app.game.dungeon.DungeonCreationStrategy;
import com.auto.app.game.dungeon.DungeonPlayStrategy;
import com.auto.app.game.themestrategy.ThemCreationContext;
import com.auto.app.game.themestrategy.ThemePlayContext;
import com.auto.app.game.util.Color;
import com.auto.app.game.util.ColorPrintStream;

import java.io.*;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameWindow {

    private List<Theme> themes = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        GameWindow gameWindow = new GameWindow();
        gameWindow.initializeTheme();
    }

    public void initializeTheme() {
        boolean themeStart;
        ColorPrintStream.printWithColor("========================Game Window=================================", Color.GREEN, Color.BLACK_BACKGROUND);
        themeStart = true;
        themes = loadTheme();
        while (themeStart) {
            ColorPrintStream.printWithColor("List of Themes:", Color.CYAN, Color.BLACK_BACKGROUND);
            for (int index = 0; index < themes.size(); index++) {
                System.out.println(index + 1 + " - " + themes.get(index).getName());
            }
            int userChoice = scanner.nextInt();
            if (userChoice > 0 && themes.size() >= userChoice &&
                    "Dungeon and Dragon".equals(themes.get(userChoice - 1).getName())) {
                boolean check;
                try {
                    ColorPrintStream.printWithColor("Do you want to load the game\n" + "1. Yes\n" + "2. No\n", Color.CYAN, Color.BLACK_BACKGROUND);
                    userChoice = scanner.nextInt();
                    check = new File(URLDecoder.decode("G:\\Job Quest abroad\\game CLI\\testsave\\" + "save.ser", "UTF-8")).exists();
                    if (check && 1 == userChoice) {
                        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(URLDecoder.decode("G:\\Job Quest abroad\\game CLI\\testsave\\", "UTF-8") + "save.ser"));
                        Theme theme = (Theme) inputStream.readObject();
                        ThemePlayContext themePlayContext = new ThemePlayContext();
                        themePlayContext.setThemePlayStrategy(new DungeonPlayStrategy());
                        themePlayContext.play(theme, scanner);
                    } else if (!check && 1 == userChoice) {
                        System.out.println("did find any saved game.");
                        createAndLoad();
                    } else {
                        createAndLoad();
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
//                Mario
                themeStart = false;
            }
//            set themeStart false to end game
        }
        System.out.println("==============================End====================================");
    }

    private void createAndLoad() {
        ThemCreationContext context = new ThemCreationContext();
        context.setThemeCreatoinStrategy(new DungeonCreationStrategy());
        Theme dungeonTheme = context.createTheme(scanner);
        ThemePlayContext themePlayContext = new ThemePlayContext();
        themePlayContext.setThemePlayStrategy(new DungeonPlayStrategy());
        themePlayContext.play(dungeonTheme, scanner);
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
