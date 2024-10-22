package com.ohgiraffers.section01.subsection03.setter;

import com.ohgiraffers.section01.common.BookDAO;
import com.ohgiraffers.section01.common.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bookserviceSetter")
public class BookService {

    private BookDAO bookDAO;

    @Autowired
    public void setBookDAO(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    //메소드가 호출됬을때 애러 생성자는 호출방법은 바로 알려줄수있으니까
    // 생성자에 Autowired가있으면 실행될때 오류가있으면 먼저뱉는다!! 좀더 안정성이 보장된다!
    //여러의존성있을수있는데 다넣어주면 그냥 필드에넣고 오토와이드하면되니까

    public List<BookDTO> selectAllBooks()
    {
        return bookDAO.selectBookList();
    }
    public BookDTO selectOneBook(int seq) {
        return bookDAO.selectOneBook(seq);
    }
}
