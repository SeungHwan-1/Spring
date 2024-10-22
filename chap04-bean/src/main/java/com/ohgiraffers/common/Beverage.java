package com.ohgiraffers.common;

public class Beverage extends Product{

    private int capacity; // yongliang

    public Beverage(String name, int price, int capacity) {
        super(name, price);
        this.capacity = capacity;
    }

    public Beverage() {
        super();
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return super.toString() + " " + this.capacity;
    }
}
