package com.example.day12.IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test4 {
    public static void main(String[] args) {
        //파일로 부터 읽어서  --  입력 통로가 필요
        //파일에 쓴다.   --  출력통로가 필요.//
        try (FileInputStream in = new FileInputStream("src//com//example//day12//txt//Test.txt");
             FileOutputStream out = new FileOutputStream("src//com//example//day12//txt//Test4Output.txt");) {
            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}