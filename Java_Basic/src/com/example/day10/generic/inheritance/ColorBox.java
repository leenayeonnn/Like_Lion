package com.example.day10.generic.inheritance;

public class ColorBox<T, C> extends Box<T> {
    private C color;

    public ColorBox(T content, C color) {
        super(content);
        this.color = color;
    }

    public C getColor() {
        return color;
    }

    @Override
    public void printContent() {
        System.out.println("Colored box with color " + color + " containing: " + getContent());
    }

}
