package com.example.day13.thread.thread;

public class MyThread1 extends Thread {
    @Override
    public void run() {
        System.out.println("MyThread1 start");
        for (int i = 0; i < 10; i++) {
            System.out.println("hi - thread1");
        }
        System.out.println("MyThread1 end");
    }
}
