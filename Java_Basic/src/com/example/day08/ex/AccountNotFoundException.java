package com.example.day08.ex;

public class AccountNotFoundException extends RuntimeException {

    public AccountNotFoundException(String msg) {
        super(msg);
    }

    public AccountNotFoundException() {
        this("해당 통장이 없습니다");
    }
}
