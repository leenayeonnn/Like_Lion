package com.example.day16;

public class Car {
    private String name;
    private int speed;

    public Car() {
    }

    public Car(String name) {
        this.name = name;
    }

    public Car(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    @Override
    public String toString() {
        return name + " , " + speed;
    }
}
