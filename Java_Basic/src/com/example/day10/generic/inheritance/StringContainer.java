package com.example.day10.generic.inheritance;

public class StringContainer implements Container<String> {
    private String value;

    @Override
    public void set(String value) {
        this.value = value;
    }

    @Override
    public String get() {
        return value;
    }
}
