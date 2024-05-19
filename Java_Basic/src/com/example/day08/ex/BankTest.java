package com.example.day08.ex;

import java.util.Scanner;
import java.util.StringTokenizer;

public class BankTest {
    public static void main(String[] args) {

        Bank bank = new Bank("신한", 3);
        Banker banker = new Banker("은행원");

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("1. 개설, 2. 출금, 3. 입금, 4. 특정 계좌 확인, 0. 종료 : ");
            int select = sc.nextInt();

            if (select == 0) {
                break;
            }

            switch (select) {
                case 1:
                    openBankProcess(bank, banker);
                    break;
                case 2:
                    withDrawProcess(bank, banker);
                    break;
                case 3:
                    depositProcess(bank, banker);
                    break;
                case 4:
                    findBankProcess(bank);
                    break;
                default:
                    System.out.println("잘못된 입력입니다.");
            }
        }
    }

    private static void openBankProcess(Bank bank, Banker banker) {
        Scanner sc = new Scanner(System.in);

        try {
            if (banker.openApproval(bank)) {
                System.out.print("예금주명과 넣을 금액을 입력하세요 (금액 생략 가능) : ");
                StringTokenizer st = new StringTokenizer(sc.nextLine());

                String name = st.nextToken();
                if (st.hasMoreTokens()) {
                    bank.addAccount(name, Integer.parseInt(st.nextToken()));
                } else {
                    bank.addAccount(name);
                }
            }
        } catch (AccountAmountFullException e) {
            System.out.println("통장 개설이 불가합니다.");
        }
    }

    private static void withDrawProcess(Bank bank, Banker banker) {
        Scanner sc = new Scanner(System.in);

        System.out.print("출금하기 원하는 계좌 번호 입력 : ");
        try {
            int accountNumber = sc.nextInt();
            if (banker.withdrawApproval(bank, accountNumber)) {
                System.out.print("출금하기 원하는 금액 입력 : ");
                bank.getAccount(accountNumber).withdraw(sc.nextInt());
            }
        } catch (AccountNotFoundException e) {
            System.out.println("해당 계좌가 없습니다.");
        } catch (InsufficientFundsException e) {
            System.out.println("잔액이 부족합니다.");
        }
    }

    private static void depositProcess(Bank bank, Banker banker) {
        Scanner sc = new Scanner(System.in);

        System.out.print("입금하기 원하는 계좌 번호 입력 : ");
        try {
            int accountNumber = sc.nextInt();
            if (banker.depositApproval(bank, accountNumber)) {
                System.out.print("입금하기 원하는 금액 입력 : ");
                bank.getAccount(accountNumber).deposit(sc.nextInt());
            }
        } catch (AccountNotFoundException e) {
            System.out.println("해당 계좌가 없습니다.");
        }
    }

    private static void findBankProcess(Bank bank) {
        Scanner sc = new Scanner(System.in);

        System.out.print("확인을 원하는 계좌 번호 입력 : ");

        try {
            bank.inquiryAccount(sc.nextInt());
        } catch (AccountNotFoundException e) {
            System.out.println("해당 계좌가 없습니다.");
        }
    }
}
