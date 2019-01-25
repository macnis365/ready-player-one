package com.auto.app.game.themestrategy;

import com.auto.app.game.component.Theme;
import com.auto.app.game.customexception.GameIllegalStateException;

import java.util.Scanner;

public interface ThemePlayStrategy {
    public void play(Theme theme) throws GameIllegalStateException;
}
