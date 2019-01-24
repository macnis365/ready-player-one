package com.auto.app.game.event;

import com.auto.app.game.component.Player;
import com.auto.app.game.component.Theme;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class SaveCommand implements Command {
    Theme theme;

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
            System.out.println("The Object  was succesfully written to a file");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
