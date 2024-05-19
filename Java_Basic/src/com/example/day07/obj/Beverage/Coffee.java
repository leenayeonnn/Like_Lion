package com.example.day07.obj.Beverage;

public class Coffee extends BeverageRecipe {
    @Override
    void brew() {
        System.out.println("필터를 통해 커피를 우려냅니다.");
    }
    @Override
    void addCondiments() {
        System.out.println("설탕과 우유를 추가합니다.");
    }
}