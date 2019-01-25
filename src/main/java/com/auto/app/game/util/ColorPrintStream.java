package com.auto.app.game.util;

public class ColorPrintStream {

    public static void printWithColor(String message, Color background, Color text) {
        System.out.print(text);
        System.out.print(background);
        System.out.print(message);
    }

    public static void printTextColor(String message, Color text) {
        System.out.print(text);
        System.out.print(message);
    }

    public static void printBackgroundColor(String message, Color background) {
        System.out.print(background);
        System.out.println(message);
    }

    public static void printBackgroundColorWithNoMessage(Color background) {
        System.out.println(background);
    }

    public static void printBackgroundColorWithNoMessage(Color background, int line) {
        for (int index = 0; index < line; index++) {
            System.out.println(background);
        }
    }

    public static void setBackgroundColor(Color backgroundColor) {
        System.out.print(backgroundColor);
    }

    public static void setTextColor(Color textColor) {
        System.out.print(textColor);
    }
}
