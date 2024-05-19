package com.example.day10.generic.basic;

import java.util.ArrayList;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        // 제네릭 사용시
        // 해당 타입만 대입 가능

        List<String> strList = new ArrayList<>();
        strList.add("test");
//        strList.add(12);

        String sValue = strList.get(0);
    }
}
