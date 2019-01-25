package com.auto.app.game.util;

public class ColorPrintStream {

    public static void printWithColor(String message, Color background, Color text) {
        System.out.print(text);
        System.out.println(background + message);
    }

    public static void printTextColor(String message, Color text) {
        System.out.print(text);
        System.out.println(message);
    }

    public static void printBackgroundColor(String message, Color background) {
        System.out.print(background);
        System.out.println(message);
    }

    public static void printBackgroundColorWithNoMessage(Color background) {
        System.out.println(background);
    }
}
