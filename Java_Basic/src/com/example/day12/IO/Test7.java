package com.example.day12.IO;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test7 {
    public static void main(String[] args) {
        // 1. 5줄 입력받아 콘솔 출력
        // 2. 파일에 출력

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             FileWriter fw = new FileWriter("src//com//example//day12//txt//Test7Write.txt");) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 5; i++) {
                sb.append(br.readLine() + "\n");
            }

            System.out.println(sb);

            fw.write(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
