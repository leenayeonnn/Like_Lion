package com.example.day11.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PersonTest {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person("kang", 30));
        list.add(new Person("kim", 20));
        list.add(new Person("hong", 43));

        System.out.println(list);

        // 1. 객체에 Comparable 구현
        Collections.sort(list);
        System.out.println(list);

        // 2. 익명 객체 사용
        Collections.sort(list, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        System.out.println(list);
    }
}
