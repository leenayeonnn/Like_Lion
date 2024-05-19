package com.example.day08.exception;

public class Test1 {
    public static void main(String[] args) {
        int[] iarr = {1, 2, 3};

//        System.out.println(iarr[3]);
//
//        System.out.println("next 1");
//        System.out.println("next 2");
//        System.out.println("next 3");
//        System.out.println("next 4");
//        System.out.println("- end -");

        try {
            System.out.println(iarr[3] + "층입니다");
            System.out.println("문이 열립니다.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("해당 층은 없습니다.");
        } finally {
            System.out.println("next 1");
            System.out.println("next 2");
            System.out.println("next 3");
            System.out.println("next 4");
            System.out.println("- end -");
        }
    }
}
