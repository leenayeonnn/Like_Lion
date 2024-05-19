package com.example.chattingProgram.server;

import com.example.chattingProgram.server.domain.Client;
import com.example.chattingProgram.server.domain.Room;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.HashMap;
import java.util.Map;

public class ChatServer {
    private final static int PORT_NUMBER = 12345;

    public static void main(String[] args) {

        Map<String, Client> clients = new HashMap<>();
        Map<Integer, Room> rooms = new HashMap<>();

        try (ServerSocket serverSocket = new ServerSocket(PORT_NUMBER)) {
            System.out.println("서버 준비 완료");

            while (true) {
                new ServerThead(serverSocket.accept(), clients, rooms).start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
