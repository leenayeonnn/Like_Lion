package com.example.day10.generic.wild;

import java.util.Arrays;
import java.util.List;

public class GenericWildCard {
    public static void pringList(List<?> list) {
        for (Object element : list) {
            System.out.println(element);
        }
    }

    public static <T> void printFirst(List<? extends T> list) {
        if (!list.isEmpty()) {
            T item = list.get(0);
            System.out.println(item);
        }
    }

    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 3);
        List<String> stringList = Arrays.asList("hello", "world");
        List<Double> doubleList = Arrays.asList(1.2, 3.4);

        pringList(intList);
        pringList(stringList);
        pringList(doubleList);

        System.out.println("===========");

        printFirst(intList);
        printFirst(stringList);
        printFirst(doubleList);
    }
}
