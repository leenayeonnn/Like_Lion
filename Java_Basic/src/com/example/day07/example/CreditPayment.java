package com.example.day07.example;

public class CreditPayment implements Payment{
    @Override
    public void processPayment() {
        System.out.println("카드 결재");
    }
}
