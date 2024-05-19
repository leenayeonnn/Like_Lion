package com.example.day07.example;

public class OrderTest {
    public static void main(String[] args) {
        Order order1 = new BurgerOrder();
        order1.completeOrder();
        Payment payment1 = new CashPayment();
        payment1.processPayment();

        Order order2 = new PizzaOrder();
        order2.completeOrder();
        Payment payment2 = new CreditPayment();
        payment2.processPayment();
    }
}
