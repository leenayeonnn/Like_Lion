package com.example.day10.generic.inheritance;

public class Box<T> {
    private T content;

    public Box(T content) {
        this.content = content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public T getContent() {
        return content;
    }

    public void printContent() {
        System.out.println("Box containing: " + content);
    }
}
