package com.ohgiraffers.section02.javaconfig;

import com.ohgiraffers.common.Account;
import com.ohgiraffers.common.MemberDTO;
import com.ohgiraffers.common.PersonalAccount;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContextConfiguration {

    @Bean
    public Account accountGenerator(){
        return new PersonalAccount(20,"110-233-2222");
    }//동작할때마다 새롭게 계속 만들어짐 밑에서 빈으로 등록해주면 의존성알아서 해주고 싱글톤으로 관리해줌
    @Bean
    public MemberDTO memeberGenerator(){
        MemberDTO member = new MemberDTO(30,"홍석천","010-2222-3333", "hong@gmail.com",
                accountGenerator());
        return member;
    }
}
