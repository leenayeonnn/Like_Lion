package com.example.day13.thread.test;

import com.example.day13.thread.thread.MyThread1;
import com.example.day13.thread.thread.MyThread2;
import com.example.day13.thread.thread.MyThread3;

public class MyThread3Test {
    public static void main(String[] args) {
        System.out.println("MyThread2Test start");

        MyThread1 thread1 = new MyThread1();
        Thread thread2 = new Thread(new MyThread2());
        Thread thread3 = new Thread(new MyThread3());
        thread1.start();
        thread2.start();
        thread3.start();

        for (int i = 0; i < 10; i++) {
            System.out.println("main hi");
        }

        System.out.println("MyThread2Test end");
    }
}
