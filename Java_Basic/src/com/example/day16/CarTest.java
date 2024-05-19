package com.example.day16;

import java.util.function.BiFunction;
import java.util.function.Function;

public class CarTest {
    public static void main(String[] args) {
        Function<String, Car> func = Car::new;
        Car car1 = func.apply("car1");
        System.out.println(car1.toString());

        BiFunction<String, Integer, Car> biFunc = Car::new;
        Car car2 = biFunc.apply("car2", 30);
        System.out.println(car2.toString());
    }
}
