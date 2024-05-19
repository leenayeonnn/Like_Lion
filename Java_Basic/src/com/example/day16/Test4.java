package com.example.day16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Test4 {
    public static void main(String[] args) {
        Consumer<String> printStr = s -> System.out.println(s);
        printStr.accept("안녕");

        Consumer<Integer> printInt = i -> System.out.println(i);
        List<Integer> nums = Arrays.asList(1,2,3,4,5);
        nums.forEach(printInt);

        Predicate<Integer> isPositive = x -> x > 0;
        System.out.println(isPositive.test(3));

        Function<String, Integer> lengthFunc = s -> s.length();
        System.out.println(lengthFunc.apply("hello"));

        Supplier<Double> randomSupplier = () -> Math.random();
        System.out.println(randomSupplier.get());
    }
}
