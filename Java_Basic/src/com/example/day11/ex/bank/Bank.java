package com.example.day11.ex.bank;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private String name;
    private List<Account> accounts = new ArrayList<>();

    public void addAccount(Account account) {
        if (accounts.contains(account)) {
            accounts.add(account);
            System.out.println("추가 완료");
        } else {
            System.out.println("계설 불가한 계좌번호 입니다.");
        }
    }

    public Account findAccount(int number) {
        for (Account account : accounts) {
            if (account.getNumber() == number) {
                return account;
            }
        }

        return null;
    }
}
