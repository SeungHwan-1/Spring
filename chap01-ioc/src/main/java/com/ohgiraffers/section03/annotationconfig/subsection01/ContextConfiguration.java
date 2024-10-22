package com.ohgiraffers.section03.annotationconfig.subsection01;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration("configurationSection03")
@ComponentScan(basePackages = "com.ohgiraffers.common")
// ComponentScan 하위경로중에 @Component bean이 있다면 부를 수  있게 해준다.
// 빈으로 등록하게하는것?
public class ContextConfiguration {

}
