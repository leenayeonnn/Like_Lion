package com.example.day10.collection;

import java.util.ArrayList;
import java.util.List;

public class Test3 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(4);
        System.out.println(list);

        int value = list.get(0);

        // 인덱스로 제거
        System.out.println(list.remove(0));
        System.out.println(list);

        // 값 자체로 제거
        System.out.println(list.remove(Integer.valueOf(4)));
        System.out.println(list);

        // 값 포함 여부
        System.out.println(list.contains(5));

        // 모든 값 삭제
        list.clear();
        System.out.println(list);
    }
}
