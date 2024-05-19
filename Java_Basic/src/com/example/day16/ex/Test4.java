package com.example.day16.ex;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Test4 {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("hello", "world", "java", "hahahaha");

        Predicate<String> lengthOverFive = (s) -> s.length() >= 5;

        for (String str : stringList) {
            if (lengthOverFive.test(str)) {
                System.out.println(str);
                break;
            }
        }
    }
}
