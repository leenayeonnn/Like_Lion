package com.example.day13.syncronize;

public class TichetTest {
    public static void main(String[] args) {
        TicketBooth ticketBooth = new TicketBooth();
        TicketBuyer ticketBuyer1 = new TicketBuyer("buy1", false, ticketBooth);
        TicketBuyer ticketBuyer2 = new TicketBuyer("buy2",false, ticketBooth);
        TicketBuyer ticketBuyer3 = new TicketBuyer("buy3",true, ticketBooth);

        ticketBuyer1.start();
        ticketBuyer2.start();
        ticketBuyer3.start();
    }
}
