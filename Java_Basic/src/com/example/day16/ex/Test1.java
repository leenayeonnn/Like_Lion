package com.example.day16.ex;

import java.util.*;

public class Test1 {
    public static void main(String[] args) {
        List<String> strList = Arrays.asList("banana", "apple", "cherry", "watermelon", "strawberry", "mango");
        Collections.sort(strList, (s1, s2) -> s1.length() - s2.length());

        System.out.println(strList);
    }
}
