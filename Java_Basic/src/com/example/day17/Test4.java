package com.example.day17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test4 {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Apple", "Banana", "Cherry", "Apple", "Cherry", "Date");

        System.out.println("-- map --");

        System.out.println("대문자로 변환");
        List<String> result3 = new ArrayList<>();
        words.stream().map(String::toUpperCase).forEach(result3::add);
        System.out.println(result3);

        System.out.println("숫자에 3 곱하기");
        int[] iArr = {1, 2, 3, 4, 5, 6};
        List<Integer> result4 = new ArrayList<>();
        Arrays.stream(iArr).map(i -> i * 3).forEach(result4::add);
        System.out.println(result4);
        System.out.println();

    }
}
