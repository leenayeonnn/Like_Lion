package com.example.day10.generic.bounded;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GenericSuper {
    public static void addNumbers(List<? super Integer> list) {
        for (int i = 1; i <= 5; i++) {
            list.add(i);
        }
    }

    public static void main(String[] args) {
        List<Number> numbersList = new ArrayList<>();
        List<Object> objectList = new ArrayList<>();

        addNumbers(numbersList);
        addNumbers(objectList);

        System.out.println("num : " + numbersList);
        System.out.println("obj : " + objectList);
    }
}
