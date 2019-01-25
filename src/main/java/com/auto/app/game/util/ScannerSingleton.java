package com.auto.app.game.util;

import java.util.Scanner;

import static com.auto.app.game.util.Constants.INVALID_INPUT_ERROR_MESSAGE;

public class ScannerSingleton {
    private final Scanner scanner;

    private ScannerSingleton() {
        scanner = new Scanner(System.in);
    }

    private static class InputOutputHelper {
        private static final ScannerSingleton INPUT_OUTPUT = new ScannerSingleton();
    }

    public static int getIntegerInput() {
        validateInputForInteger();
        return InputOutputHelper.INPUT_OUTPUT.scanner.nextInt();
    }

    private static void validateInputForInteger() {
        while (!ScannerSingleton.hasNextInteger()) {
            ColorPrintStream.printWithColor(INVALID_INPUT_ERROR_MESSAGE, Color.RED, Color.BLACK_BACKGROUND);
            ColorPrintStream.printBackgroundColorWithNoMessage(Color.BLACK_BACKGROUND, 1);
            ColorPrintStream.printWithColor(">\t", Color.YELLOW, Color.BLACK_BACKGROUND);
            ScannerSingleton.getStringInput();
        }
    }

    public static boolean hasNextInteger() {
        return InputOutputHelper.INPUT_OUTPUT.scanner.hasNextInt();
    }

    public static String getStringInput() {
        return InputOutputHelper.INPUT_OUTPUT.scanner.next();
    }
}
