package com.example.day11.set;

import java.util.Objects;

public class Pen {
    private String color;

    public Pen(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Pen{" +
                "color='" + color + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pen pen = (Pen) o;
        return Objects.equals(color, pen.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color);
    }
}
