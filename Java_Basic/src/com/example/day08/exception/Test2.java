package com.example.day08.exception;

public class Test2 {
    public static void main(String[] args) {
        System.out.println("program start");

        int i = Integer.parseInt(args[0]);

        try {
            System.out.println(10 / i);
        } catch (ArithmeticException e) {
            System.out.println("예외 발생 [ " + e.getMessage() + " ]");
        } finally {
            System.out.println("program end");
        }

    }
}
