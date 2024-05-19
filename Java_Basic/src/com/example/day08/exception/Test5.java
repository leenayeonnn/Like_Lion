package com.example.day08.exception;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Test5 {
    public static void main(String[] args) {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             Scanner sc = new Scanner(System.in)) {

        } catch (IOException e) {

        }
    }
}
