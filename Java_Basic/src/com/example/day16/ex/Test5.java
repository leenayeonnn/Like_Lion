package com.example.day16.ex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Test5 {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> results = new ArrayList<>();

        Function<Integer, Integer> square = (i) -> i * i;

        for (int i : integerList) {
            results.add(square.apply(i));
        }

        System.out.println(results);
    }
}
