package com.example.day16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class Test6 {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> maxFunc = Math::max;
        System.out.println(maxFunc.apply(3, 5));

        String str = "hello";
        Supplier<Integer> lengthFunc = str::length;
        System.out.println(lengthFunc.get());

        List<String> words = Arrays.asList("hello", "world", "java");
        List<Integer> lengths = new ArrayList<>();

        Function<String, Integer> lengthFunc2 = String::length;
        for (String word : words) {
            lengths.add(lengthFunc2.apply(word));
        }
        System.out.println(lengths);

        Supplier<List<String>> listSupplier = ArrayList::new;

        List<String> list = listSupplier.get();
        list.add("hello");
        list.add("hahaha");

        System.out.println(list);
    }
}
