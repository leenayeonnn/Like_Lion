package com.example.day14.multiChat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.util.HashMap;
import java.util.Map;

public class Test1Server {
    private static final int PORT = 12345;
    private static final Map<String, PrintWriter> allClients = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("채팅 서버가 시작되었습니다.");
        try (ServerSocket listener = new ServerSocket(PORT)) {
            while (true) {
                new Test1Handler(listener.accept(), allClients).start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}