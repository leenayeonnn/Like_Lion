package com.example.day12.ex;

import java.io.*;
import java.util.StringTokenizer;

public class PhoneNumberManage {
    public static void main(String[] args) {

        // 파일 저장
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter pw = new PrintWriter("src//com//example//day12//ex//txt//phoneNumber.txt");) {

            System.out.println("3명 입력");

            for (int i = 0; i < 3; i++) {
                System.out.print("이름 : ");
                String name = br.readLine();

                System.out.print("번호 : ");
                String number = br.readLine();
                pw.println(name + " " + number);
            }

            System.out.println("저장 완료");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("======================");

        // 읽어오기
        try (BufferedReader br = new BufferedReader(new FileReader("src//com//example//day12//ex//txt//phoneNumber.txt"));) {

            System.out.println("저장 내용 출력");
            String str;
            while ((str = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(str);
                System.out.println("이름 : " + st.nextToken() + " / 번호 : " + st.nextToken());
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
