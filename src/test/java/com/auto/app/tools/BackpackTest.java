package com.auto.app.tools;

import com.auto.app.com.auto.app.tools.Backpack;
import com.auto.app.com.auto.app.tools.Item;
import com.auto.app.com.auto.app.tools.Skull;
import org.junit.Test;

public class BackpackTest {

    @Test
    public void testShowInventory(){
        Backpack backpack = new Backpack("wildcraft");
        Item item1 = new Skull("Human");
        Item item2 = new Skull("Animal");
        backpack.add(item1);
        backpack.add(item2);
        System.out.println(backpack.show());
    }
}
