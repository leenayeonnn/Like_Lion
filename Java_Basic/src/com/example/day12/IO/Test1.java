package com.example.day12.IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test1 {
    // byte 단위
    public static void main(String[] args) throws IOException {
//        System.out.println(System.getProperties());
        FileInputStream fis = new FileInputStream("src\\com\\example\\day12\\txt\\Test.txt"); // 시작이 프로젝트 메인 폴더 부터임
        FileOutputStream fos = new FileOutputStream("src\\com\\example\\day12\\txt\\Test1Output.txt");
        FileOutputStream fos2 = new FileOutputStream("src\\com\\example\\day12\\txt\\Test1Output2.txt");

        int n;
        byte[] bytes = new byte[1024];
//        while ((n = fis.read(bytes)) != -1) { // EOF시 -1 반환
//            String str = new String(bytes);
//            System.out.println(str);
//            fos.write(bytes);
//        }

        while ((n = fis.read()) != -1) {
            System.out.println((char) n);
            fos2.write(n);
        }

        fos2.close();
        fos.close(); // close 안하면 제대로 파일이 써지지 않음
        fis.close();
    }
}
