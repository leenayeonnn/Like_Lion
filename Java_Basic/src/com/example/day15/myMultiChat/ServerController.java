package com.example.day15.myMultiChat;

import com.example.day15.myMultiChat.domain.ChatRoom;
import com.example.day15.myMultiChat.domain.Client;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServerController {
    private static final int SERVER_PORT = 1024;

    public void run() {
        // 메인 서버 준비
        try (ServerSocket serverSocket = new ServerSocket(SERVER_PORT);) {
            System.out.println("서버가 준비되었습니다.");

            // 방 및 클라이언드 할당 준비
            List<ChatRoom> chatRooms = new ArrayList<>();
            Map<Client, PrintWriter> clients = new HashMap<>();
            while (true) {
                //2. accept() 를 통해서 소켓을 얻어옴.   (여러명의 클라이언트와 접속할 수 있도록 구현)
                Socket socket = serverSocket.accept();
                new ServerThread(socket, chatRooms, clients).start();

            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
