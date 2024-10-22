package com.ohgiraffers.section01.common;

import org.springframework.stereotype.Indexed;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("bookDAO") // 연결해주는 빈으로 관리뿐더러 스프링에서 이게 데이터베이스연결하는곳
public class BookDAOimpl implements BookDAO{

    private Map<Integer,BookDTO> bookList;

    public BookDAOimpl() {
        bookList = new HashMap<>();
        bookList.put(1,new BookDTO(1,123,"자바의정석",
                "남궁성","도우출판",new Date()));
        bookList.put(2,new BookDTO(2,456,"컨테이너",
                "문성주","길벗",new Date()));
    }

    @Override
    public List<BookDTO> selectBookList() {
        return new ArrayList<>(bookList.values());
    }

    @Override
    public BookDTO selectOneBook(int seq) {
        return bookList.get(seq);
    }
}
