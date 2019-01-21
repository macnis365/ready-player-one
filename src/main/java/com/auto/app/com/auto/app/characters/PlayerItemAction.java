package com.auto.app.com.auto.app.characters;

import com.auto.app.com.auto.app.tools.Item;

public interface PlayerItemAction {
    String examine(Item item);
    void collect(Item item);
    String lift(Item item);
}
