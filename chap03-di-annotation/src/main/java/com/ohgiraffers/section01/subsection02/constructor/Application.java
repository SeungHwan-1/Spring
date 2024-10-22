package com.ohgiraffers.section01.subsection02.constructor;

import com.ohgiraffers.section01.common.BookDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(
                "com.ohgiraffers.section01");

        // BookService 빈을 가져오기
        BookService bookService = context.getBean(BookService.class);

        // 모든 책을 선택
        List<BookDTO> bookList = bookService.selectAllBooks();

        // 책 리스트 출력
        for (BookDTO book : bookList) {
            System.out.println("book = " + book);
        }
    }
}