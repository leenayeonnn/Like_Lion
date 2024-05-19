package com.example.day17;

import java.util.Arrays;
import java.util.List;

public class Test9 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        int result = list.stream().reduce(0, Integer::sum);
        System.out.println(result);
    }
}
