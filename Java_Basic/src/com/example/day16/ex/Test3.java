package com.example.day16.ex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Test3 {
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(5, 2, 63, 3, 18);
        List<Integer> results = new ArrayList<>();

        intList.forEach((i) -> results.add(i + 10));

        System.out.println(results);
    }
}
