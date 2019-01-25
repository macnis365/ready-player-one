package com.auto.app.game.util;

public class ColorPrintStream {

    static final boolean WINDOWS_ENVIRONMENT = System.getProperty("os.name").startsWith("Windows");

    public static void printWithColor(String message, Color background, Color text) {
        if (!WINDOWS_ENVIRONMENT) {
            System.out.print(text);
            System.out.print(background);
        }
        System.out.print(message);
    }

    public static void printBackgroundColorWithNoMessage(Color background) {
        if (!WINDOWS_ENVIRONMENT) {
            System.out.println(background);
        }
    }

    public static void printBackgroundColorWithNoMessage(Color background, int line) {
        for (int index = 0; index < line; index++) {
            if (!WINDOWS_ENVIRONMENT) {
                System.out.print(background);
            }
            System.out.println();
        }
    }
}
