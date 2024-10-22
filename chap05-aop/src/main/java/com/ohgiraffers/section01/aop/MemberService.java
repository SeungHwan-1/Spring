package com.ohgiraffers.section01.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MemberService {

    private final MemberDAO memberDAO;


    @Autowired //의존성주입
    public MemberService(MemberDAO memberDAO) {
        this.memberDAO = memberDAO;
    }
    public Map<Integer,MemberDTO> selectMembers() {
        System.out.println("selectMembers 메소드, 실행");
        return memberDAO.selectMembers();
    }
    public MemberDTO selectMember(int id) {
        System.out.println("selectMembers 메소드, 실행");
        return memberDAO.selectMember(id);
    }

    @Override
    public String toString() {
        return "MemberService Bean";
    }
}
