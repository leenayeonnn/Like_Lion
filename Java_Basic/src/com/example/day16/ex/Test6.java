package com.example.day16.ex;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Test6 {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> integerList2 = Arrays.asList(2, 4);

        Predicate<Integer> isEven = (x) -> x % 2 == 0;

        boolean flag = true;
        for (int i : integerList) {
            if (!isEven.test(i)) {
                flag = false;
                break;
            }
        }
        System.out.println(flag);

        flag = true;
        for (int i : integerList2) {
            if (!isEven.test(i)) {
                flag = false;
                break;
            }
        }
        System.out.println(flag);
    }
}
