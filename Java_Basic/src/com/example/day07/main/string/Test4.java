package com.example.day07.main.string;

public class Test4 {
    public static void main(String[] args) {
        String str = "java programming";

        System.out.println(str.charAt(3));
        System.out.println(str.substring(3));
        System.out.println(str.substring(3, 7));

        System.out.println("===================");

        String str2 = "     abc     ";

        if ("abc".equals(str2)) {
            System.out.println(true);
        } else{
            System.out.println(false);
        }

        if ("abc".equals(str2.trim())) {
            System.out.println(true);
        } else{
            System.out.println(false);
        }
    }
}
