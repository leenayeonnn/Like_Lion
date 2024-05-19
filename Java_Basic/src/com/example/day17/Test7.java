package com.example.day17;

import java.util.Arrays;

public class Test7 {
    public static void main(String[] args) {
        int[] intArr = {2, 4, 6, 8};
        boolean result;

        result = Arrays.stream(intArr).allMatch(i -> i % 3 == 0);
        System.out.println("all is 3배수 : " + result);

        result = Arrays.stream(intArr).anyMatch(i -> i % 3 == 0);
        System.out.println("least one is 3배수 : " + result);

        result = Arrays.stream(intArr).noneMatch(i -> i % 3 == 0);
        System.out.println("all is not 3배수 : " + result);
    }
}
