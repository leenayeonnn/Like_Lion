package com.example.day10.collection;

import java.util.ArrayList;

public class Test1 {
    public static void main(String[] args) {
        ArrayList<String> strList = new ArrayList<>();
        strList.add("a");
        strList.add("b");
        strList.add("c");

        System.out.println(strList.size());

        strList.add("a");
        strList.add("b");
        strList.add("c");
        strList.add("a");
        strList.add("b");
        strList.add("c");
        strList.add("a");
        strList.add("b");
        strList.add("c");

        System.out.println(strList.size());

        for(String str : strList){
            System.out.println(str);
        }
    }
}
