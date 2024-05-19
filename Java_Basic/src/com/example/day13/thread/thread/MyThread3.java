package com.example.day13.thread.thread;

public class MyThread3 implements Runnable {
    @Override
    public void run() {
        System.out.println("MyThread3 start");
        for (int i = 0; i < 10; i++) {
            System.out.println("hi - thread3");
        }
        System.out.println("MyThread3 end");
    }
}