package com.ohgiraffers.common;

// 추상클래스만들기 공통기능을 강제화하기위해?
public abstract class Product {
    //얘를 상속받으면 다사용할수 있다.
    private String name;//상품명

    private int price; // 가격

    @Override
    public String toString() {
        return
                name +
                " " + price
                ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public Product() {

    }
    }

