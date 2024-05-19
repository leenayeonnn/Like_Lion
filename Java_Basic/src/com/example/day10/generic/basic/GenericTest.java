package com.example.day10.generic.basic;

public class GenericTest {
    public static void main(String[] args) {
        Generic<String, Integer> pair = new Generic<>("Hello", 5);
        String first = pair.getFirst(); // 캐스팅 불필요
        Integer second = pair.getSecond(); // 캐스팅 불필요
    }
}
