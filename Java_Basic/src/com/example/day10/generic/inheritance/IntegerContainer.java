package com.example.day10.generic.inheritance;

public class IntegerContainer implements Container<Integer> {
    private int value;

    @Override
    public void set(Integer value) {
        this.value = value;
    }

    @Override
    public Integer get() {
        return value;
    }
}
