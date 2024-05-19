package com.example.day16;

public class Test2 {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("thread : " + i);
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("thread : " + i);
            }
        }).start();
    }
}
