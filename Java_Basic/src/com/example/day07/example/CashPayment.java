package com.example.day07.example;

public class CashPayment implements Payment{
    @Override
    public void processPayment() {
        System.out.println("현금 결재");
    }
}
