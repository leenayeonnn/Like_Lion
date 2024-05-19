package com.example.day17;

import java.util.Arrays;

public class Test8 {
    public static void main(String[] args) {
        int[] intArr = {12, 36, 53, 35, 66, 57};

        long count = Arrays.stream(intArr).count();
        int max = Arrays.stream(intArr).max().orElse(-1);
        int min = Arrays.stream(intArr).min().orElse(-1);
        int sum = Arrays.stream(intArr).sum();
        double ave = Arrays.stream(intArr).average().orElse(-1);

        System.out.println("count : " + count);
        System.out.println("max : " + max);
        System.out.println("min : " + min);
        System.out.println("sum : " + sum);
        System.out.println("ave : " + ave);
    }
}
