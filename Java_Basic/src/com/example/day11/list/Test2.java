package com.example.day11.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();

        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);
        integerList.add(5);
        integerList.add(6);

        System.out.println(integerList);

        Collections.shuffle(integerList);
        System.out.println(integerList);

        Collections.sort(integerList);
        System.out.println(integerList);
    }
}
