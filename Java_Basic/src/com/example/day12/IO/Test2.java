package com.example.day12.IO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test2 {
    public static void main(String[] args) throws IOException {

        // 키보드로 부터 한줄씩 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println(str);

        // 파일로 부터 한줄씩 입력
        BufferedReader br2 = new BufferedReader(new FileReader("src//com//example//day12//txt//Test.txt"));
        String str2 = br2.readLine();
        System.out.println(str2);
    }
}
