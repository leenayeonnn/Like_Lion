package com.example.day07.example;

public class PizzaOrder extends Order{
    @Override
    public void prepareFood() {
        System.out.println("피자를 준비합니다");
    }

    @Override
    public void serveFood() {
        System.out.println("피자를 서빙합니다.");
    }
}
