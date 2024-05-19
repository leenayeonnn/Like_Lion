package com.example.day13.thread.test;

import com.example.day13.thread.thread.MyTread4;

public class MyThread4Test {
    public static void main(String[] args) {
        System.out.println("main thread 시작.");
        Runnable one = new MyTread4("영희");
        Thread thread = new Thread(one);

        Runnable two = new MyTread4("철수");
        Thread thread2 = new Thread(two);


        thread.start();
        thread2.start();
        System.out.println("main thread 끝.");
    }
}
