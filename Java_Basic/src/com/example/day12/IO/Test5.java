package com.example.day12.IO;

import java.io.FileReader;
import java.io.IOException;

public class Test5 {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("src//com//example//day12//txt//Test.txt");
        int ch;
        while ((ch = fr.read()) != -1) {
            System.out.println((char) ch);
        }
    }
}
