package com.ohgiraffers.section03.annotationconfig.subsection01;

import com.ohgiraffers.common.MemberDAO;
import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {

        /*
        * ComponentScan
        * base Packages 로 설정 된 하위 경로에ㅐ 특정 어노테이션을 가지고 있는
        * 클래스를 빈으로 등록하는 기능이다
        * @Component 어노테이션이 작성된 클래스를 인시하여 bean으로 등록한다./
        * 특수 목적에 따라 @Controller, @Service등을 사용한다.
        *
         */

        ApplicationContext context = new AnnotationConfigApplicationContext(
                ContextConfiguration.class);
        
        String[] beanNames = context.getBeanDefinitionNames();
        // 스프링컨테이너가 내부적으로 사용하는 빈들 이름이다.
        for (String bean : beanNames) {
            System.out.println("bean = " + bean);
        }


        MemberDAO memberDAO = context.getBean(MemberDAO.class);
        //따로 객체를 생성안해도
        System.out.println(memberDAO.selectMember(1));
        System.out.println(memberDAO.insertMember(new MemberDTO(3,"user03","pass03",        "홍돌돌")));
        System.out.println(memberDAO.selectMember(3));
    }
}

