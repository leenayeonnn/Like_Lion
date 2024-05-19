package com.example.day10.generic.bounded;

public class GenericBounded {
    public static <T extends Number> T max(T x, T y, T z) {
        T max = x;
        if (y.doubleValue() > max.doubleValue()) {
            max = y;
        }

        if (z.doubleValue() > max.doubleValue()) {
            max = z;
        }

        return max;
    }
}
