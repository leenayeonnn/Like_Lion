package com.example.day13.thread.thread;

// 쓰레드가 아니기 때문에
// 생성시 Thread로 감싸줘야함
public class MyThread2 implements Runnable {
    @Override
    public void run() {
        System.out.println("MyThread2 start");
        for (int i = 0; i < 10; i++) {
            System.out.println("hi - thread2");
        }
        System.out.println("MyThread2 end");
    }
}
