package com.ohgiraffers.common;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private final List<Product> items;
    //final이라 얘자체를 바구는거기때문에 불가능함.
    public ShoppingCart()
    {
        items = new ArrayList<>();
    }
    public void addItem(Product item){
        items.add(item);
    }

    public List<Product> getItems() {
        return items;
    }
}
