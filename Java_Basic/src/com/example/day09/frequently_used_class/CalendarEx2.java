package com.example.day09.frequently_used_class;

import java.util.Calendar;
import java.util.Scanner;

public class CalendarEx2 {
    public static void main(String[] args) {
        while (true) {
            Calendar calendar = input();

            if (calendar == null) {
                break;
            }

            printCalendar(calendar);
        }
    }

    private static Calendar input() {
        Scanner sc = new Scanner(System.in);

        System.out.print("원하는 년도 입력 (-1 입력시 종료) : ");
        int year = sc.nextInt();

        if (year == -1) {
            return null;
        }

        System.out.print("원하는 달 입력 : ");
        int month = sc.nextInt();

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);

        return calendar;
    }

    private static void printCalendar(Calendar calendar) {
        System.out.println();
        System.out.println(calendar.get(Calendar.YEAR) + "년 " + (calendar.get(Calendar.MONTH) + 1) + "월");
        System.out.println("sun\tmon\ttue\twed\tthu\tfri\tsat");

        int day = printFirstWeek(calendar);
        printRemainWeek(calendar, day);
    }

    private static int printFirstWeek(Calendar calendar) {
        int firstDay = calendar.get(Calendar.DAY_OF_WEEK);
        for (int i = 1; i < firstDay; i++) {
            System.out.print("\t");
        }

        int day = 1;
        for (int i = firstDay; i <= 7; i++) {
            System.out.print(day++ + "\t");
        }
        System.out.println();

        return day;
    }

    private static void printRemainWeek(Calendar calendar, int day) {
        int lastDay = calendar.getActualMaximum(Calendar.DATE);
        for (int w = 1; w < calendar.getActualMaximum(Calendar.WEEK_OF_MONTH); w++) {
            for (int i = 0; i < 7; i++) {
                System.out.print(day++ + "\t");

                if (day > lastDay) {
                    break;
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
