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
import java.util.ArrayList;
import java.util.List;

import static com.auto.app.game.util.Constants.*;

public class GameWindow {

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
            boolean isGameFileExist = false;
            ColorPrintStream.printBackgroundColorWithNoMessage(Color.BLACK_BACKGROUND, 1);
            ColorPrintStream.printWithColor(">\t", Color.YELLOW, Color.BLACK_BACKGROUND);
            userChoice = ScannerSingleton.getIntegerInput();
            if (userChoice > 0 && themes.size() >= userChoice &&
                    "Dungeon and Dragon".equals(themes.get(userChoice - 1).getName())) {
                try {
                    ColorPrintStream.printBackgroundColorWithNoMessage(Color.BLACK_BACKGROUND, 1);
                    ColorPrintStream.printWithColor(LOAD_MASSAGE, Color.CYAN, Color.BLACK_BACKGROUND);
                    ColorPrintStream.printBackgroundColorWithNoMessage(Color.BLACK_BACKGROUND, 1);
                    ColorPrintStream.printWithColor(">\t", Color.YELLOW, Color.BLACK_BACKGROUND);
                    userChoice = ScannerSingleton.getIntegerInput();
                    String directoryPath = getClass().getProtectionDomain().getCodeSource().getLocation().getPath() + "/default.ser";
                    File file = new File(directoryPath);
                    if (!file.isDirectory() && file.exists()) {
                        isGameFileExist = true;
                    }
                    if (isGameFileExist && 1 == userChoice) {
                        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(directoryPath));
                        Theme theme = (Theme) inputStream.readObject();
                        ThemePlayContext themePlayContext = new ThemePlayContext();
                        themePlayContext.setThemePlayStrategy(new DungeonPlayStrategy());
                        themePlayContext.play(theme);
                    } else if (!isGameFileExist && 1 == userChoice) {
                        ColorPrintStream.printBackgroundColorWithNoMessage(Color.BLACK_BACKGROUND, 1);
                        ColorPrintStream.printWithColor(LOAD_WARNING_MESSAGE, Color.BLACK_BACKGROUND, Color.YELLOW);
                        ColorPrintStream.printBackgroundColorWithNoMessage(Color.BLACK_BACKGROUND, 1);
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
//        Theme theme2 = new Theme.ThemeBuilder().buildWithName("Super Mario").build();
        themes.add(theme1);
//        themes.add(theme2);
        return themes;
    }

}