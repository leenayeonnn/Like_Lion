package com.example.day09.frequently_used_class;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TimeEx2 {
    public static void main(String[] args) {
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println("현재 날짜와 시간(시간대 포함): " + now);
        // 포맷팅하여 출력
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");
        System.out.println("포맷팅된 날짜와 시간: " + now.format(formatter));

        System.out.println("=================");

        ZonedDateTime nowInNewYork = now.withZoneSameInstant(ZoneId.of("America/New_York"));
        System.out.println("현재 시간(뉴욕): " + nowInNewYork);
    }
}
