package com.example.day11.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test1 {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            numbers.add(i); // 1부터 10까지 숫자를 리스트에 추가
        }
        System.out.println("원래 순서: " + numbers);
        Collections.shuffle(numbers); // 리스트 섞기
        System.out.println("섞은 후: " + numbers);
    }
}

