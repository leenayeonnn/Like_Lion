package com.example.day16.ex;

import java.util.Arrays;

public class Test2 {
    public static void main(String[] args) {
        Integer[] arr = {2, 76, 2, 64, 24, 19};
        Arrays.sort(arr, (a,b) -> {
            return b - a;
        });
        System.out.println(arr[0]);
    }
}
