package com.example.day16;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Test1 {
    public static void main(String[] args) {
        List<String> items = Arrays.asList("apple", "banana", "cherry");

        Consumer<String> consumers = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        items.forEach(item -> System.out.println(item));
        items.forEach(consumers);
    }
}
