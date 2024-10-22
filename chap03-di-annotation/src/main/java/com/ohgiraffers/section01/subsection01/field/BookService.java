package com.ohgiraffers.section01.subsection01.field;

import com.ohgiraffers.section01.common.BookDAO;
import com.ohgiraffers.section01.common.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bookServiceField") // 이름붙이는게 의미는 없다
public class BookService {
    @Autowired //DI 필드 위에 주입하는 방법 인터페이스인지아닌지보고 인터페이스면 그자식을 넣어줌
                //여러개 있으면 순서를 정해줘야함
    private BookDAO bookDAO;

    public List<BookDTO> selectAllBook(){
        return bookDAO.selectBookList();
    }

    public BookDTO selectOneBook(int seq)
    {
        return bookDAO.selectOneBook(seq);
    }



}
