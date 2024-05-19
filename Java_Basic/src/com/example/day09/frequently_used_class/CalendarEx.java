package com.example.day09.frequently_used_class;

import java.util.Calendar;

public class CalendarEx {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);

        System.out.println(calendar.get(Calendar.MONTH));
        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(calendar.get(Calendar.DATE));

        System.out.println(calendar.getActualMinimum(Calendar.DATE));
        System.out.println(calendar.getActualMaximum(Calendar.DATE));
    }
}
