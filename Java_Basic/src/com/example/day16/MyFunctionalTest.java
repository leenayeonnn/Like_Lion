package com.example.day16;

public class MyFunctionalTest {
    public static void main(String[] args) {
        // 메서드가 하나만 존재해야 람다식 사용 가능
        MyFunctionalInterface myFunctionalInterface = () -> System.out.println("method1");
        myFunctionalInterface.method1();

    }
}
