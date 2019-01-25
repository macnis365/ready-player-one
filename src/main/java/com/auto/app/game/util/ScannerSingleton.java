package com.auto.app.game.util;

import java.util.Scanner;

public class ScannerSingleton {
    private final Scanner scanner;

    private ScannerSingleton() {
        scanner = new Scanner(System.in);
    }

    private static class InputOutptHelper {
        private static final ScannerSingleton INPUT_OUTPUT = new ScannerSingleton();
    }

    public static Scanner getInstance() {
        return InputOutptHelper.INPUT_OUTPUT.scanner;
    }

    public static int getIntegerInput() {
        return InputOutptHelper.INPUT_OUTPUT.scanner.nextInt();
    }

    public static String getStringInput() {
        return InputOutptHelper.INPUT_OUTPUT.scanner.next();
    }
}
