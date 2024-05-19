package com.example.chattingProgram.server.domain;

import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Room {
    private int roomNumber;
    private Map<String, Client> clients = new HashMap<>();

    public Room(int newRoomNumber) {
        this.roomNumber = newRoomNumber;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public synchronized void add(Client me) {
        clients.put(me.getNickname(), me);
        me.setRoomNumber(roomNumber);
    }

    @Override
    public String toString() {
        return String.valueOf(roomNumber);
    }

    public Collection<Client> allClient() {
        return clients.values();
    }

    public void remove(Client me) {
        clients.remove(me.getNickname());
    }

    public boolean nobody() {
        return clients.isEmpty();
    }
}
