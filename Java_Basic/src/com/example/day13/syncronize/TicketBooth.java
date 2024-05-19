package com.example.day13.syncronize;

public class TicketBooth {
    public synchronized void notCutInLine(String name) {
        System.out.println("구매 시작: " + name);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("구매완료 : " + name);
    }

    public void cutInLine(String name) {
        System.out.println("새치기! 구매 완료 : " + name);
    }
}
