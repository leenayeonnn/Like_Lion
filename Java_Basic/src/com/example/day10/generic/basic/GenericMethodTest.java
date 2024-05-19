package com.example.day10.generic.basic;

public class GenericMethodTest {
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 5};
        GenericMethod.printArrayElements(arr);

        String[] strArr = {"hello", "world"};
        GenericMethod.printArrayElements(strArr);
    }
}
