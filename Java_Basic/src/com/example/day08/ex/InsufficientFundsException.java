package com.example.day08.ex;

public class InsufficientFundsException extends RuntimeException {
    public InsufficientFundsException(String msg) {
        super(msg);
    }

    public InsufficientFundsException() {
        this("잔액이 부족합니다");
    }
}
