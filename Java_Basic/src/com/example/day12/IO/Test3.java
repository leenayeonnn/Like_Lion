package com.example.day12.IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test3 {
    public static void main(String[] args) {
        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream("src//com//example//day12//txt//Test.txt");
            out = new FileOutputStream("src//com//example//day12//txt//Test3Output.txt");

            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (out != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
