package com.example.day13.ex;

public class CountTest {
    public static void main(String[] args) {
        Thread incremetnThread = new Thread(new IncrementCounter());
        Thread decremetnThread = new Thread(new DecrementCounter());

        incremetnThread.start();
        decremetnThread.start();
    }
}
