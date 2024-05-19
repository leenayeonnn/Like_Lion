package com.example.day10.generic.bounded;

public class GenericExtends<T extends Number> {

    private T number;

    public GenericExtends(T number) {
        this.number = number;
    }

    public double square() {
        return number.doubleValue() * number.doubleValue();
    }

    public static void main(String[] args) {
        GenericExtends<Integer> intCalculator = new GenericExtends<>(5);
        GenericExtends<Double> doubleCalculator = new GenericExtends<>(5.5);

        System.out.println("Integer square: " + intCalculator.square());
        System.out.println("Double square: " + doubleCalculator.square());
    }

}