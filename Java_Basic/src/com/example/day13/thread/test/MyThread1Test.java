package com.example.day13.thread.test;

import com.example.day13.thread.thread.MyThread1;

public class MyThread1Test {
    public static void main(String[] args) {
        System.out.println("MyThread1Test start");

        MyThread1 myThread1 = new MyThread1();
        myThread1.start();

        for (int i = 0; i < 30; i++) {
            System.out.println("main hi");
        }

        System.out.println("MyThread1Test end");
    }
}
