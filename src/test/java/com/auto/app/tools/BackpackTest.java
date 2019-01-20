package com.auto.app.tools;

import com.auto.app.com.auto.app.tools.Backpack;
import com.auto.app.com.auto.app.tools.Item;
import com.auto.app.com.auto.app.tools.Utensil;
import org.junit.Test;

public class BackpackTest {

    @Test
    public void testShowInventory() {
        Backpack backpack = new Backpack();
        Item item1 = new Utensil("Skull", "", 10);
        Item item2 = new Utensil("Magic Spell", "", 10);
        backpack.add(item1);
        backpack.add(item2);
        System.out.println(backpack.show());
    }
}
