package com.example.day17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test1 {
    public static void main(String[] args) {
        System.out.println("-- a로 시작하는 요소 출력 --");

        List<String> list = Arrays.asList("a", "b", "c", "d");

        System.out.println("스트림 사용");
        List<String> filterList = list.stream()
                .filter(s -> s.startsWith("a"))
                .collect(Collectors.toList());

        System.out.println(filterList);

        System.out.println("스트림 미사용");
        List<String> filterList2 = new ArrayList<>();
        for (String s : list) {
            if (s.startsWith("a")) {
                filterList2.add(s);
            }
        }
        System.out.println(filterList2);
        System.out.println();


        System.out.println("-- 모두 출력 --");
        String[] names = {"lee", "kim", "kang", "park"};

        System.out.println("스트림 사용");
        Arrays.stream(names).forEach(System.out::println);

        System.out.println("스트림 미사용");
        for (String name : names) {
            System.out.println(name);
        }
        System.out.println();


        System.out.println("-- 양수 출력 --");
        int[] iarr = {1, 2, 3, 4, 5, 6, 7, 8};

        System.out.println("스트림 사용");
        Arrays.stream(iarr).filter(i -> i % 2 == 0).forEach(System.out::println);

        System.out.println("스트림 미사용");
        for (int i : iarr) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }
}