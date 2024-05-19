package com.example.day16;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class Test3 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 3, 26, 5, 8);

        Collections.sort(numbers, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        System.out.println(numbers);


        Collections.sort(numbers, (Integer o1, Integer o2) -> o1.compareTo(o2));
        numbers.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });
    }
}
