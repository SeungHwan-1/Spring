package com.ohgiraffers.section01.common;

import java.util.List;

public interface BookDAO {
    //도서목록 전체조회
    List<BookDTO> selectBookList();
    //도서번호로 도서 조회

    BookDTO selectOneBook(int seq);
}
