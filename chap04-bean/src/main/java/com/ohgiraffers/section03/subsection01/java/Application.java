package com.ohgiraffers.section03.subsection01.java;

import com.ohgiraffers.common.Beverage;
import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.ShoppingCart;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new GenericXmlApplicationContext(
                "section03/xml/context.xml");

        Bread bread = (Bread) context.getBean("carpBread");
        Beverage water =(Beverage) context.getBean("water");
        Beverage milk =(Beverage) context.getBean("milk");
        ShoppingCart cart = (ShoppingCart) context.getBean("cart");
        ShoppingCart cart2 = (ShoppingCart) context.getBean("cart");

        cart.addItem(bread);
        cart.addItem(milk);
        System.out.println("cart에 담긴 물품 :" + cart.getItems());
        //두번째 손님이 카트를 꺼낸다.

        cart2.addItem(water);
        System.out.println("cart2 에 담긴 물품 :" + cart2.getItems());

        ((GenericXmlApplicationContext) context).close();
        //자식에게있기때문에 형번환 해줘야함
    }
}
