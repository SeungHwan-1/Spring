package com.ohgiraffers.section01.aop;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Repository
public class MemberDAO {
    private final Map<Integer,MemberDTO> memberMap;

    public MemberDAO(){
        memberMap = new HashMap<>();
        memberMap.put(1,new MemberDTO(1,"유관순"));
        memberMap.put(2,new MemberDTO(2,"흥나숭"));
    }

    public Map<Integer, MemberDTO> selectMembers() {
        return memberMap;
    }

    public MemberDTO selectMember(int id) {
        MemberDTO retrunMember = memberMap.get(id);
        if(Objects.isNull(retrunMember)) {
            throw new RuntimeException(" 해당 아이디를 가진 회원은 존재하지 않습니다.");
            }
            return retrunMember;
        }
    }

