package com.example.day11.set;

import java.util.HashSet;
import java.util.Set;

public class Test1 {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        set.add("d");
        set.add("a");
        set.add("b");
        set.add("c");
        System.out.println(set);

        set.add("a");
        System.out.println(set);

        if (set.contains("a")) {
            System.out.println("true");
        } else{
            System.out.println("false");
        }

    }
}
