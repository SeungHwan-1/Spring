package com.ohgiraffers.common;

public interface Account {

    String getBalance(); // 잔액
    String deposit(int money); //입금
    String withdraw(int money); //출금
    //인터페이스로 책임을 의무화
}
