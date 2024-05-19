package com.example.day13.ex;

import java.io.*;
import java.util.Scanner;

public class FileWriterTask implements Runnable {
    @Override
    public void run() {
        try (Scanner sc = new Scanner(System.in);
             PrintWriter pw = new PrintWriter("src//com//example//day13//ex//txt//output.txt");) {
            while (true) {
                System.out.println("입력");
                String str;
                if ((str = sc.nextLine()).isEmpty()) {
                    break;
                }
                pw.println(str);
            }
            System.out.println("입력 종료");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
