package com.example.day09.frequently_used_class;

public class SystemEx {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 2000000000; i++) {

        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }
}
