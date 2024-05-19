package com.example.day13.ex;

public class DecrementCounter implements Runnable {
    @Override
    public void run() {
        for (int i = 100; i >= 1; i--) {
            System.out.println("decrement : " + i);
            try {
                Thread.sleep((int)(Math.random() * 11));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
