package com.example.day15.myMultiChat.domain;


import com.example.day15.myMultiChat.ChatRoomThread;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.util.*;

public class ChatRoom {
    private int roomNumber;
    private ServerSocket serverSocket;
    private Map<Client, PrintWriter> clients = new HashMap<>();
    private String password;

    public ChatRoom(int roomNumber) throws IOException {
        this.roomNumber = roomNumber;
        this.serverSocket = new ServerSocket(roomNumber);
    }

    public void changeToPrivate(String password) {
        this.password = password;
    }

    public void enter(Client me) throws IOException {
        new ChatRoomThread(serverSocket.accept(), me, clients).start();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Integer)) return false;
        int i = (Integer) o;
        return i == roomNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomNumber);
    }
}
