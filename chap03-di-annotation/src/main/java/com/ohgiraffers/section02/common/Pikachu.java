package com.ohgiraffers.section02.common;


import org.springframework.stereotype.Component;

@Component
public class Pikachu implements Pokemon {


    @Override
    public void attack() {
        System.out.println("피카츄의 용성군");
    }

}
