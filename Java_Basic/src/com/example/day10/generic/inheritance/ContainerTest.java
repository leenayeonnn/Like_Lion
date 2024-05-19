package com.example.day10.generic.inheritance;

public class ContainerTest {
    public static void main(String[] args) {
        Container<String> strContainer = new StringContainer();
        strContainer.set("hello");
        System.out.println("StringContainer : " + strContainer.get());

        Container<Integer> intContainer = new IntegerContainer();
        intContainer.set(10);
        System.out.println("IntegerContainer : " + intContainer.get());
    }
}
