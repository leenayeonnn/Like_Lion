package com.example.day13.ex;

public class IncrementCounter implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            System.out.println("increment : " + i);
            try {
                Thread.sleep((int)(Math.random() * 11));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
