package com.example.day07.main.abstractClass;

import com.example.day07.obj.Product;

/*
 * toString
 * : 실체를 확인하지 않고 내용물을 확인하는 용도로 자주 쓰임
 *
 * equals
 * : 주소를 비교하기 때문에
 * 사용자 정의 클래스에서 원하는대로 작동하기 위해 오버라이드 필수
 */
public class Test2 {
    public static void main(String[] args) {
        String str = "hello";

        System.out.println(str);
        System.out.println(str.toString());

        Product pen = new Product("검정펜", 3000);

//        pen.getName();
//        pen.getPrice();
        System.out.println(pen);

        Product pen2 = new Product("검정펜", 3000);

        if (pen.equals(pen2)) {
            System.out.println("same");
        } else {
            System.out.println("diff");
        }
    }
}
