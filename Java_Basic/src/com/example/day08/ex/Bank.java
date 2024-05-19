package com.example.day08.ex;

public class Bank {
    private static int haveAccount = 0;
    private final String bankName;
    private final Account[] accounts;

    public Bank(String bankName, int possibleAccountNum) {
        this.bankName = bankName;
        this.accounts = new Account[possibleAccountNum];
    }

    public void addAccount(String owner) {
        this.addAccount(owner, 0);
    }

    public void addAccount(String owner, int balance) {
        this.accounts[haveAccount++] = new Account(owner, balance);
    }

    public void inquiryAccount(int accountNumber) {
        this.getAccount(accountNumber).printAccountInfo();
    }

    public boolean haveSpace() {
        return haveAccount < accounts.length;
    }

    public Account getAccount(int accountNumber) throws AccountNotFoundException {
        for (int i = 0; i < haveAccount; i++) {
            if (accounts[i].getAccountNumber() == accountNumber) {
                return accounts[i];
            }
        }

        throw new AccountNotFoundException();
    }
}
