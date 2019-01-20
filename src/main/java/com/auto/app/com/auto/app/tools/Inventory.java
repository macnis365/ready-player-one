package com.auto.app.com.auto.app.tools;

import java.util.List;

interface Inventory {
    public void add(Item item);

    public boolean remove(Item item);

    public String show();
}
