package com.auto.app.game;

import com.auto.app.GameWindow;
import com.auto.app.game.component.Theme;
import com.auto.app.game.customexception.GameIllegalStateException;
import com.auto.app.game.themestrategy.ThemePlayContext;
import com.auto.app.game.util.ScannerSingleton;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.Mockito.doThrow;

@RunWith(PowerMockRunner.class)
public class GameWindowTest {
    GameWindow gameWindow;

    @Before
    public void setUp() {
        gameWindow = new GameWindow();
    }

    @Test
    @PrepareForTest(ScannerSingleton.class)
    public void terminateGracefully() throws GameIllegalStateException {
        PowerMockito.mockStatic(ScannerSingleton.class);
        Mockito.when(ScannerSingleton.getIntegerInput()).thenReturn(2);
        ThemePlayContext themePlayContext = Mockito.mock(ThemePlayContext.class);
        Theme theme = Mockito.mock(Theme.class);
        doThrow(new GameIllegalStateException("game error state")).when(themePlayContext).play(theme);
        gameWindow.initializeTheme();
    }
}
