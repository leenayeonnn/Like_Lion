package com.example.day08.ex;

public class Banker {
    private static int count = 0;
    private final String name;
    private final int id;

    public Banker(String name) {
        this.name = name;
        this.id = ++count;
    }

    public boolean openApproval(Bank bank) throws AccountAmountFullException {
        if (bank.haveSpace()) {
            return true;
        }

        throw new AccountAmountFullException();
    }

    public boolean withdrawApproval(Bank bank, int accountNumber) throws AccountNotFoundException {
        if (bank.getAccount(accountNumber) != null) {
            return true;
        }

        throw new AccountNotFoundException();
    }

    public boolean depositApproval(Bank bank, int accountNumber) throws AccountNotFoundException {
        if (bank.getAccount(accountNumber) != null) {
            return true;
        }

        throw new AccountNotFoundException();
    }
}
