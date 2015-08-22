package com.example.noaht.orientationchanges.demo;

import java.io.Serializable;

public class Item implements Serializable {

    private int mItemNumber;

    public Item(int itemNumber) {
        mItemNumber = itemNumber;
    }

    @Override
    public String toString() {
        return "List Item " + mItemNumber;
    }
}
