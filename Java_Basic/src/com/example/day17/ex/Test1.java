package com.example.day17.ex;

import java.util.Arrays;

public class Test1 {
    public static void main(String[] args) {
        int[] numbers = {3, 10, 4, 17, 6};
        int sum = Arrays.stream(numbers).filter(i -> i % 2 == 0).sum();
        System.out.println(sum);
    }
}
