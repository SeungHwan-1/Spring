package com.ohgiraffers.section01.aop;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true) //aop 기능을하기위해서 오토프록시를 켜주면된다.
public class ContextConfiguration {

    /*
    * aspectJ의 AutoProxy 사용에 관한 설정을 해 주어야 advice가 동작한다.
    * proxyTargetClass = true 설정은
    * cglib을 이용한 프록시를 생성하는 방식이다.
    * (cglib : 클래스 기반의 프록시를 생성하는 라이브러리
    * 메소드 호출을 가로채기 위해 실제 클래스의 서브클래스를 만든다.)
     */
}
