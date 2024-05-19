package com.example.day10.generic.basic;

public class NonGenericTest {
    public static void main(String[] args) {
        NonGeneric pair = new NonGeneric("test", 5);
        String first = (String) pair.getFirst(); // 캐스팅 필요
        Integer second = (Integer) pair.getSecond(); // 캐스팅 필요
    }
}
