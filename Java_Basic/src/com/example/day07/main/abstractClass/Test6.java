package com.example.day07.main.abstractClass;

import com.example.day07.obj.shape.Shape;
import com.example.day07.obj.shape.Triangle;
import com.example.day07.obj.shape.Rectangle;

public class Test6 {
    public static void main(String[] args) {
        Shape triangle = new Triangle(10, 5);
        System.out.println("삼각형의 너비: " + triangle.calculateArea());

        Shape rectangle = new Rectangle(10, 20);
        System.out.println("사각형의 너비: " + rectangle.calculateArea());
    }
}
