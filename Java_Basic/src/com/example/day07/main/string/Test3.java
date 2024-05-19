package com.example.day07.main.string;

// 불변 객체 String
public class Test3 {
    public static void main(String[] args) {
        String str1 = "hello";
        String str2 = "hello";
        String str3 = new String("hello");
        String str4 = new String("hello");

        // String 메모리 구역에 같은 값이 있을시
        // 해당 값을 참조함
        if(str1 == str2){
            System.out.println("same");
        } else{
            System.out.println("diff");
        }

        // 생성자를 통한 String 객체는
        // String 메모리의 내용과 무관하게
        // 새롭게 생성됨
        if(str1 == str3){
            System.out.println("same");
        } else{
            System.out.println("diff");
        }

        // String.equals는 값을 비교함
        if (str1.equals(str3)) {
            System.out.println("same");
        } else{
            System.out.println("diff");
        }

        // 서로 다른 객체임
        if(str3 == str4){
            System.out.println("same");
        } else{
            System.out.println("diff");
        }

        if(str3.equals(str4)){
            System.out.println("same");
        } else{
            System.out.println("diff");
        }

        System.out.println(str1.concat("test"));
        System.out.println(str1);

        str1 = str1.concat("test");
        System.out.println(str1);
    }
}
