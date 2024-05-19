package com.example.day07.inter;

public interface Vehicle {
    int MAX_SPEED = 120;

    void accelerate(int increase);
    void decelerate(int decrease);
}
