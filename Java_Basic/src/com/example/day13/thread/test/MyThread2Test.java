package com.example.day13.thread.test;

import com.example.day13.thread.thread.MyThread2;

public class MyThread2Test {
    public static void main(String[] args) {
        System.out.println("MyThread2Test start");

        Thread thread = new Thread(new MyThread2());
        thread.start();

        for (int i = 0; i < 30; i++) {
            System.out.println("main hi");
        }

        System.out.println("MyThread2Test end");
    }
}
