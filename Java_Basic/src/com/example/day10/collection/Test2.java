package com.example.day10.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Test2 {
    public static void main(String[] args) {
        // 인터페이스를 이용하면
        // 구현체가 바뀌어도
        // 코드 수정 X

//        List<String> list = new ArrayList<>();
        List<String> list = new Vector<>();

        list.add("a");
        list.add("b");
        list.add("c");

        for(String str : list){
            System.out.println(str);
        }
    }
}
