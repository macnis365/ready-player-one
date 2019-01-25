package com.auto.app;

import com.auto.app.game.component.Theme;
import com.auto.app.game.customexception.GameIllegalStateException;
import com.auto.app.game.dungeon.DungeonCreationStrategy;
import com.auto.app.game.dungeon.DungeonPlayStrategy;
import com.auto.app.game.themestrategy.ThemCreationContext;
import com.auto.app.game.themestrategy.ThemePlayContext;
import com.auto.app.game.util.Color;
import com.auto.app.game.util.ColorPrintStream;
import com.auto.app.game.util.ScannerSingleton;

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
                    FileInputStream fileInputStream = null;
                    if (1 == userChoice) {
                        try {
                            fileInputStream = new FileInputStream(DEFAULT_FILENAME);
                        } catch (FileNotFoundException fileEx) {
                            ColorPrintStream.printBackgroundColorWithNoMessage(Color.BLACK_BACKGROUND, 1);
                            ColorPrintStream.printWithColor(LOAD_WARNING_MESSAGE, Color.BLACK_BACKGROUND, Color.YELLOW);
                            ColorPrintStream.printBackgroundColorWithNoMessage(Color.BLACK_BACKGROUND, 1);
                            createAndLoad();
                        }
                        ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
                        Theme theme = (Theme) inputStream.readObject();
                        ThemePlayContext themePlayContext = new ThemePlayContext();
                        themePlayContext.setThemePlayStrategy(new DungeonPlayStrategy());
                        themePlayContext.play(theme);
                    } else {
                        createAndLoad();
                    }
                } catch (GameIllegalStateException e) {
                    ColorPrintStream.printWithColor(e.getMessage(), Color.BLACK_BACKGROUND, Color.YELLOW);
                } catch (Exception e) {
                    ColorPrintStream.printWithColor("******System error*****", Color.BLACK_BACKGROUND, Color.YELLOW);
                }
            } else {
                themeStart = false;
            }
        }

        ColorPrintStream.printWithColor("==============================End====================================", Color.GREEN, Color.BLACK_BACKGROUND);
    }

    private void createAndLoad() throws GameIllegalStateException {
        ThemCreationContext context = new ThemCreationContext();
        context.setThemeCreatoinStrategy(new DungeonCreationStrategy());
        Theme dungeonTheme = context.createTheme();
        ThemePlayContext themePlayContext = new ThemePlayContext();
        themePlayContext.setThemePlayStrategy(new DungeonPlayStrategy());
        themePlayContext.play(dungeonTheme);
    }

    public List<Theme> loadTheme() {
        Theme theme1 = new Theme.ThemeBuilder().buildWithName("Dungeon and Dragon").build();
        themes.add(theme1);
        return themes;
    }

}