package com.example.day17.ex;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test2 {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date");

        List<String> result = words.stream().filter(s->s.length() >= 5).map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(result);
    }
}
