package com.example.day08.exception;

import java.util.Scanner;

public class MyExceptionTest {
    public static void main(String[] args) {
        MyExceptionTest myExceptionTest = new MyExceptionTest();

        Scanner sc = new Scanner(System.in);

        try {
            myExceptionTest.inputScore(sc.nextInt());
        } catch (MyException e) {
            System.out.println(e);
        }

        System.out.println("- end -");
    }

    public void inputScore(int score) {
        if (score < 0) {
            throw new MyException("under 0");
        } else if (score > 100) {
            throw new MyException("over 100");
        }
        System.out.println("score : " + score);
    }
}
