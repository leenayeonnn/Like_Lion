package com.example.day13.thread.thread;

public class MyTread4 implements Runnable {
    String name;

    public MyTread4(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("MyThread4 start");
        for (int i = 0; i < 10; i++) {
            System.out.println("hi - thread4 " + name);
            try {
                Thread.sleep((int) (Math.random() * 1000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("MyThread4 end");
    }
}
