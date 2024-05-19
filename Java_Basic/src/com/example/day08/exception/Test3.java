package com.example.day08.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Test3 {
    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("abc");
    }
}
