package com.example.day12.IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test6 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
            System.out.print("문자열 입력 : ");
            String str = br.readLine();
            System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
