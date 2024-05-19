package com.example.day09.innerClass;

public class OuterClass {
    private int outerField = 10;
    private InnerClass innerClass;

    public void outerMethod() {
        InnerClass innerClass = new InnerClass();
        innerClass.innerMethod();
    }

    class InnerClass {
        public void innerMethod() {
            System.out.println("outer Field : " + outerField);
        }
    }

    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        outerClass.outerMethod();
    }
}
