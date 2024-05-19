package com.example.day10.generic.inheritance;

public interface Container<T> {
    void set(T value);
    T get();
}
