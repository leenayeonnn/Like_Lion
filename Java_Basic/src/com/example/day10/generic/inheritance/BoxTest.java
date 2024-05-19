package com.example.day10.generic.inheritance;

public class BoxTest {
    public static void main(String[] args) {
        SpecialBox<String> specialBox = new SpecialBox<>("Hello");
        specialBox.printContent();

        ColorBox<String, String> colorBox= new ColorBox<>("Hi","Red");
        colorBox.printContent();
    }
}
