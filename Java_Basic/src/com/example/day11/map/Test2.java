package com.example.day11.map;

import java.util.HashMap;
import java.util.Map;

public class Test2 {
    public static void main(String[] args) {
        Map<String, String> phoneBook = new HashMap<>();

        phoneBook.put("김철수", "010-1234-5678");
        phoneBook.put("박영희", "010-8765-4321");
        phoneBook.put("이민지", "010-5566-7788");

        String minjiNumber = phoneBook.get("이민지");
        System.out.println("이민지의 전화번호: " + minjiNumber);

        System.out.println("전체 전화번호 목록:");

        // set 구조로 변환하여 순회 가능하게 함
        for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("==========");

        phoneBook.remove("김철수");
        System.out.println("철수 삭제 : " + phoneBook);

        System.out.println("이민지 찾기 : " + phoneBook.containsKey("이민지"));
        System.out.println("김철수 찾기 : " + phoneBook.containsKey("김철수"));

        System.out.println("010-8765-4321 찾기 : " + phoneBook.containsValue("010-8765-4321"));
        System.out.println("010-1234-5678 찾기 : " + phoneBook.containsValue("010-1234-5678"));

        System.out.println("전화번호부 비었나? : " + phoneBook.isEmpty());

        System.out.println("전화번호 개수 : " + phoneBook.size());
    }
}
