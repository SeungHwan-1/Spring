package com.ohgiraffers.section02.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary //동일한타입의 빈을 찾을때 제일 우선시
public class Charmander implements Pokemon{
    @Override
    public void attack() {
        System.out.println("파이리 단단해지기");
    }
}
