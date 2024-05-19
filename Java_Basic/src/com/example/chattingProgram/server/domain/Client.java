package com.example.chattingProgram.server.domain;

import com.example.chattingProgram.server.service.ClientSettingService;

import java.io.*;
import java.net.Socket;
import java.util.Map;

public class Client implements Closeable {
    private String nickname;
    private int caution;
    private int roomNumber;
    private final BufferedReader in;
    private final PrintWriter out;

    public Client(Socket socket, Map<String, Client> clients) throws IOException {
        this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.out = new PrintWriter(socket.getOutputStream());
        this.nickname = ClientSettingService.inputNickname(this, clients);

        clients.put(nickname, this);
        outMessage("[" + nickname + "]님 어서오세요\n");
        System.out.printf("%s 닉네임의 사용자가 연결했습니다 : %s\n", nickname, socket.getInetAddress().getHostAddress());
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getNickname() {
        return nickname;
    }

    public String inMessage() throws IOException {
        return in.readLine();
    }

    public void outMessage(String msg) {
        out.println(msg);
    }

    @Override
    public void close() throws IOException {
        in.close();
        out.close();
    }
}
