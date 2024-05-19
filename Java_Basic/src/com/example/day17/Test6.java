package com.example.day17;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Test6 {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(3, 6, 2, 5, 36, 55, 0);

        nums.stream()
                .sorted()
                .forEach(System.out::println);

        System.out.println("--------------");

        nums.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);


        System.out.println("\n==============\n");


        int[] iarr = {5, 3, 27, 9, 5, 9, 0, 4, 34};

        Arrays.stream(iarr)
                .sorted()
                .forEach(System.out::println);

        System.out.println("--------------");

        Arrays.stream(iarr)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);
    }
}
