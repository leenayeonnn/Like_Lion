package com.example.day09.frequently_used_class;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class TimeEx {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        LocalDateTime dateTime = LocalDateTime.now();

        System.out.println(date);
        System.out.println(time);
        System.out.println(dateTime);

    }
}
