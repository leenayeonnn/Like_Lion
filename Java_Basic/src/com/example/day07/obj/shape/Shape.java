package com.example.day07.obj.shape;

abstract public class Shape {
    private int width;
    private int height;

    public Shape() {
    }

    public Shape(int width, int height) {
        this.width = width;
        this.height = height;
    }

    abstract public int calculateArea();
}

