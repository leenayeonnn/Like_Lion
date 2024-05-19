package com.example.day07.inter;

public interface Calculator {
    int add(int a, int b);
    int minus(int a, int b);

    // default 메서드와 다르게
    // 오버라이드의 목적이 아닌
    // 구현해 놓음을 목적으로 사용함
    static void light(){
        System.out.println("불을 밝히다");
    }
}
