package com.example.day07.main.abstractClass;

import com.example.day07.obj.Beverage.BeverageRecipe;
import com.example.day07.obj.Beverage.Coffee;
import com.example.day07.obj.Beverage.Tea;

public class Test7 {
    public static void main(String[] args) {
        BeverageRecipe tea = new Tea();
        tea.prepareRecipe();

        System.out.println("=============");

        BeverageRecipe coffee = new Coffee();
        coffee.prepareRecipe();
    }
}
