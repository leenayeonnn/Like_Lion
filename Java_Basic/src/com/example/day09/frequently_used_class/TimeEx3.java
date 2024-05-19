package com.example.day09.frequently_used_class;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;

public class TimeEx3 {
    public static void main(String[] args) {
        LocalTime start = LocalTime.of(9, 0);
        LocalTime end = LocalTime.of(17, 0);

        Duration duration = Duration.between(start, end);
        System.out.println("근무 시간: " + duration.toHours() + "시간");

        System.out.println("==========================");

        LocalDate start2 = LocalDate.of(2020, 1, 1);
        LocalDate end2 = LocalDate.now();
        Period period = Period.between(start2, end2);
        System.out.println("기간: " + period.getYears() + "년 " + period.getMonths() + "개월 " + period.getDays() + "일");
    }
}
