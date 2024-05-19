package com.example.day08.finalEx;

public class BankAccount {
    private final int accountNumber;
    private double balance;

    public BankAccount(int accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public final String getAccountInfo() {
        return "계좌 번호: " + accountNumber + ", 잔액: " + balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }
}
