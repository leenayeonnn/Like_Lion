package com.example.day13.syncronize;

public class TicketBuyer extends Thread {
    private String name;
    private boolean cutInLine;
    private TicketBooth ticketBooth;

    public TicketBuyer(String name, boolean cutInLine, TicketBooth ticketBooth) {
        this.name = name;
        this.cutInLine = cutInLine;
        this.ticketBooth = ticketBooth;
    }

    @Override
    public void run() {
        if (cutInLine) {
            ticketBooth.cutInLine(name);
        } else {
            ticketBooth.notCutInLine(name);
        }
    }
}
