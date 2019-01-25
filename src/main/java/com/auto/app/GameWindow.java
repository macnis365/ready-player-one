package com.auto.app;

import com.auto.app.game.component.Theme;
import com.auto.app.game.dungeon.DungeonCreationStrategy;
import com.auto.app.game.dungeon.DungeonPlayStrategy;
import com.auto.app.game.themestrategy.ThemCreationContext;
import com.auto.app.game.themestrategy.ThemePlayContext;
import com.auto.app.game.util.Color;
import com.auto.app.game.util.ColorPrintStream;
import com.auto.app.game.util.ScannerSingleton;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

public class GameWindow {

    public static final String NEW_LINE = "\n";
    public static final String LOAD_MASSAGE = "Do you want to load the game" + NEW_LINE + "1. Yes" + NEW_LINE + "2. No" + NEW_LINE;
    public static final String LOAD_WARNING_MESSAGE = "did not find any saved game.";
    private List<Theme> themes = new ArrayList<>();

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
            ColorPrintStream.printBackgroundColorWithNoMessage(Color.BLACK_BACKGROUND, 2);
            ColorPrintStream.printWithColor("List of Themes:" + NEW_LINE, Color.CYAN, Color.BLACK_BACKGROUND);
            for (int index = 0; index < themes.size(); index++) {
                System.out.println(index + 1 + " - " + themes.get(index).getName());
            }
            int userChoice;
            ColorPrintStream.printBackgroundColorWithNoMessage(Color.BLACK_BACKGROUND, 1);
            ColorPrintStream.printWithColor(">\t", Color.YELLOW, Color.BLACK_BACKGROUND);
            userChoice = ScannerSingleton.getIntegerInput();
            if (userChoice > 0 && themes.size() >= userChoice &&
                    "Dungeon and Dragon".equals(themes.get(userChoice - 1).getName())) {
                boolean check;
                try {
                    ColorPrintStream.printWithColor(LOAD_MASSAGE, Color.CYAN, Color.BLACK_BACKGROUND);
                    ColorPrintStream.printWithColor(">\t", Color.YELLOW, Color.BLACK_BACKGROUND);
                    userChoice = ScannerSingleton.getIntegerInput();
                    check = new File(URLDecoder.decode("G:\\Job Quest abroad\\game CLI\\testsave\\" + "save.ser", "UTF-8")).exists();
                    if (check && 1 == userChoice) {
                        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(URLDecoder.decode("G:\\Job Quest abroad\\game CLI\\testsave\\", "UTF-8") + "save.ser"));
                        Theme theme = (Theme) inputStream.readObject();
                        ThemePlayContext themePlayContext = new ThemePlayContext();
                        themePlayContext.setThemePlayStrategy(new DungeonPlayStrategy());
                        themePlayContext.play(theme);
                    } else if (!check && 1 == userChoice) {
                        System.out.println(LOAD_WARNING_MESSAGE);
                        createAndLoad();
                    } else {
                        createAndLoad();
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
//                Mario
                themeStart = false;
            }
//            set themeStart false to end game
        }

        ColorPrintStream.printWithColor("==============================End====================================", Color.GREEN, Color.BLACK_BACKGROUND);
    }

    private void createAndLoad() {
        ThemCreationContext context = new ThemCreationContext();
        context.setThemeCreatoinStrategy(new DungeonCreationStrategy());
        Theme dungeonTheme = context.createTheme();
        ThemePlayContext themePlayContext = new ThemePlayContext();
        themePlayContext.setThemePlayStrategy(new DungeonPlayStrategy());
        themePlayContext.play(dungeonTheme);
    }

    public List<Theme> loadTheme() {
        Theme theme1 = new Theme.ThemeBuilder().buildWithName("Dungeon and Dragon").build();
        Theme theme2 = new Theme.ThemeBuilder().buildWithName("Super Mario").build();
        themes.add(theme1);
        themes.add(theme2);
        return themes;
    }

}