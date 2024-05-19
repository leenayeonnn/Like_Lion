package com.example.day10.generic.basic;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Test1 {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("Test");
        list.add(10);
        list.add(Integer.valueOf(20));
        list.add(Calendar.getInstance());

        System.out.println(list);
        ///////////////
        // 제네릭이 없으면 형변환이 필수임

        String strValue = (String) list.get(0);
        Integer i = (Integer) list.get(1);
        Integer i2 = (Integer) list.get(2);
        Calendar calendar = (Calendar) list.get(3);
    }
}
