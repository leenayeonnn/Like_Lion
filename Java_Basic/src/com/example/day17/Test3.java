package com.example.day17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Test3 {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Apple", "Banana", "Cherry", "Apple", "Cherry", "Date");


        System.out.println("-- filter, distinct --");
        System.out.println("스트림 사용");
        List<String> result = words.stream().filter(s -> s.length() >= 5).distinct().toList();
        System.out.println(result);

        System.out.println("스트림 미사용");
        Set<String> tmp = Set.copyOf(words);
        List<String> result2 = new ArrayList<>();
        for (String s : tmp) {
            if (s.length() >= 5) {
                result2.add(s);
            }
        }
        System.out.println(result2);
        System.out.println();
    }
}
