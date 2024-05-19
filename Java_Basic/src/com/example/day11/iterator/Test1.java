package com.example.day11.iterator;

import java.util.*;

public class Test1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        Set<String> set = new HashSet<>();
        set.add("a");
        set.add("b");
        set.add("c");

        // Set은 순서가 없기에 get 메서드가 없음
        Iterator<String> iter = set.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

        // for each 방법
        for (String str : set) {
            System.out.println(str);
        }
    }
}
