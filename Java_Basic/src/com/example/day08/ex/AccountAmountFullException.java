package com.example.day08.ex;

public class AccountAmountFullException extends RuntimeException {
    public AccountAmountFullException(String msg) {
        super(msg);
    }

    public AccountAmountFullException() {
        this("통장 개설이 불가합니다.");
    }
}
