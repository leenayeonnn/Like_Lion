package com.example.day07.obj.shape;

import com.example.day07.inter.Drawable;

public class Rectangle extends Shape implements Drawable {
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public int calculateArea() {
        return width * height;
    }

    @Override
    public void draw() {
        System.out.println("사각형 그리기");
    }
}
