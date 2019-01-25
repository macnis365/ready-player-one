package com.auto.app.game.event;

import com.auto.app.game.component.Theme;
import com.auto.app.game.util.Color;
import com.auto.app.game.util.ColorPrintStream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import static com.auto.app.game.util.Constants.DEFAULT_FILENAME;

public class SaveCommand implements Command {
    private Theme theme;

    public SaveCommand(Theme theme) {
        this.theme = theme;
    }

    @Override
    public void execute() {

        try {
            ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream(DEFAULT_FILENAME));
            objectOut.writeObject(theme);
            objectOut.close();
            ColorPrintStream.printBackgroundColorWithNoMessage(Color.BLACK_BACKGROUND);
            ColorPrintStream.printWithColor("Game successfully saved", Color.GREEN, Color.BLACK_BACKGROUND);
            ColorPrintStream.printBackgroundColorWithNoMessage(Color.BLACK_BACKGROUND);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
