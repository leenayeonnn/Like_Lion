package com.example.day08.ex;

public class Account {
    private static int count = 0;
    private final int accountNumber;
    private final String owner;
    private int balance;

    public Account(String owner, int balance) {
        this.accountNumber = ++count;
        this.owner = owner;
        this.balance = balance;
    }

    public void deposit(int amount) {
        this.balance += amount;
    }

    public void withdraw(int amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException();
        }
        this.balance -= amount;
    }

    public void printAccountInfo() {
        System.out.println("계좌번호 : " + this.accountNumber);
        System.out.println("예금주 : " + this.owner);
        System.out.println("잔액 : " + this.balance);
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }

}
