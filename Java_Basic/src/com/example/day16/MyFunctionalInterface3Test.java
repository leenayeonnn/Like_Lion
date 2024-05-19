package com.example.day16;

public class MyFunctionalInterface3Test {
    public static void main(String[] args) {
        MyFunctionalInterface3 mfi = (x, y) -> x + y;
        System.out.println(mfi.apply(3, 4));

        ////////////
        MyFunctionalInterface3 add = (x, y) -> x + y;
        MyFunctionalInterface3 minus = (x, y) -> x - y;
        MyFunctionalInterface3 multi = (x, y) -> x * y;
        MyFunctionalInterface3 divide = (x, y) -> x / y;

        System.out.println(add.apply(1,2));
        System.out.println(minus.apply(1,2));
        System.out.println(multi.apply(1,2));
        System.out.println(divide.apply(1,2));
    }
}
