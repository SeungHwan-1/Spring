package com.ohgiraffers.common;


import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component // 이 클래스를 빈으로 등록함.
public class MemberDAO {
    private final Map<Integer,MemberDTO> memberMap;
    public MemberDAO() {
        this.memberMap = new HashMap<>();
        //이형식 바뀌는건 안되구 안에 값은 노상관

        memberMap.put(1,new MemberDTO(1,"user01","pass01","홍길동"));
        memberMap.put(2,new MemberDTO(2,"user02","pass02","홍길순"));
    }

    //매개변수로 전달 받은 회원 번호를 amp 에서 조회 후 회원 정보 리턴 메소드
    public MemberDTO selectMember(int seq){
        return memberMap.get(seq);
    }

    //매개변수로 전달 받은 회원 정보를  map 에 추가하고 성공 실패 여부를
    //boolean 형식으로 리턴하는 메소드

    public boolean insertMember(MemberDTO member){
        int before = memberMap.size();
        memberMap.put(member.getSequence(),member);
        //put 했을때 풋안되면 폴스 되면 트루
        return memberMap.size() > before? true : false;
    }
}
