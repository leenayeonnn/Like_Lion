package com.example.day07.main.abstractClass;

import com.example.day07.obj.bird.Bird;
import com.example.day07.obj.bird.Crow;
import com.example.day07.obj.bird.Pigeon;
import com.example.day07.obj.bird.Sparrow;

public class Test5 {
    public static void main(String[] args) {
        Bird bird1 = new Crow();
        Bird bird2 = new Sparrow();
        Bird bird3 = new Pigeon();
    }
}
