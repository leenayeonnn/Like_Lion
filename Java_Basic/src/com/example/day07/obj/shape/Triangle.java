package com.example.day07.obj.shape;

public class Triangle extends Shape {

    private int width;
    private int height;

    public Triangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public int calculateArea() {
        return width * height / 2;
    }
}
