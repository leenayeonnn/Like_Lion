package com.example.day08.exception;

public class MyException extends RuntimeException {
    public MyException() {
        super("MyException 발생");
    }

    public MyException(String msg) {
        System.out.println(msg);
    }
}
