package com.example.day07.example;

public abstract class Order {
    public final void completeOrder(){
        prepareFood();
        serveFood();
        System.out.println("주문이 완료되었습니다!");
    }
    public abstract void prepareFood();
    public abstract void serveFood();

}
