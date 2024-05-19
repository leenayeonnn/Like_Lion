package com.example.day11.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test1 {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();

        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");

        String firstFruit = fruits.get(0);
        System.out.println("첫 번째 과일: " + firstFruit);

        fruits.removeFirst();

        fruits.set(1, "Blueberry");

        fruits.remove("Banana");

        System.out.println("업데이트된 과일 리스트: " + fruits);

        System.out.println("===========");

        List<String> list = new LinkedList<>();
        list.add("a");
        list.add("b");

        list.remove("a");

        System.out.println(list);
    }
}
