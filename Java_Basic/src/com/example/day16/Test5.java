package com.example.day16;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.IntSupplier;
import java.util.function.UnaryOperator;

public class Test5 {
    public static void main(String[] args) {
        IntSupplier intSupplier = () -> (int) (Math.random() * 6) + 1;
        System.out.println(intSupplier.getAsInt());

        UnaryOperator<Integer> unaryOperator = (x) -> x + 1;
        System.out.println(unaryOperator.apply(3));

        BiFunction<Integer, Integer, Integer> biFunction = (x, y) -> x + y;
        System.out.println(biFunction.apply(1,2));

        Consumer<String> con1 = s -> System.out.println(s + "111");
        Consumer<String> con2 = s -> System.out.println(s + "222");

        con1.accept("test");
        con2.accept("test");

        Consumer<String> con12 = con1.andThen(con2);
        con12.accept("chain");
    }
}
