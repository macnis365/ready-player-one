package com.auto.app.game.event;

import com.auto.app.game.component.Theme;
import com.auto.app.game.util.Color;
import com.auto.app.game.util.ColorPrintStream;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class SaveCommand implements Command {
    private Theme theme;

    public SaveCommand(Theme theme) {
        this.theme = theme;
    }

    @Override
    public void execute() {
//        String path = getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
//        System.out.println(getClass().getProtectionDomain().getCodeSource());
        try {
            URLDecoder.decode("G:\\Job Quest abroad\\game CLI\\testsave", "UTF-8");
            ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream(URLDecoder.decode("G:\\Job Quest abroad\\game CLI\\testsave\\", "UTF-8") + "save.ser"));
            objectOut.writeObject(theme);
            objectOut.close();
            ColorPrintStream.printWithColor("Game successfully saved", Color.GREEN, Color.BLACK_BACKGROUND);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
