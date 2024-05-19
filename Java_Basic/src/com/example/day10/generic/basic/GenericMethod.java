package com.example.day10.generic.basic;

public class GenericMethod {
    public static <T> void printArrayElements(T[] array) {
        for (T element : array) {
            System.out.println(element);
        }
    }
}
