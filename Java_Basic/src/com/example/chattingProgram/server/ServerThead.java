package com.example.chattingProgram.server;

import com.example.chattingProgram.server.domain.Client;
import com.example.chattingProgram.server.domain.Room;
import com.example.chattingProgram.server.service.LobbyService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.*;

public class ServerThead extends Thread {
    private final Socket socket;
    private Map<String, Client> clients;
    private Map<Integer, Room> rooms;

    public ServerThead(Socket socket, Map<String, Client> clients, Map<Integer, Room> rooms) {
        this.socket = socket;
        this.clients = clients;
        this.rooms = rooms;
    }

    @Override
    public void run() {
        try (
                Client me = new Client(socket, clients)
        ) {
            LobbyService.sendCommand(me);

            while (true) {
                String msg;
                if ((msg = LobbyService.receiveMessage(me)).isBlank()) {
                    continue;
                }

                if (!LobbyService.isStartWithCommand(me, msg)) {
                    continue;
                }

                StringTokenizer st = new StringTokenizer(msg);
                String cmd = st.nextToken();

                if (!LobbyService.isCorrectCommand(me, cmd, st)) {
                    continue;
                }

                if (!LobbyService.activeByCommand(me, cmd, st, clients, rooms)) {
                    break;
                }
            }

        } catch (IOException e) {
            System.out.println(nickname + " 님이 강제종료 되었습니다");
            Map<String, PrintWriter> roomClients = rooms.get(roomNumber);

            if (roomClients != null) {
                synchronized (roomClients) {
                    rooms.get(roomNumber).remove(nickname);
                }
                if (roomClients.isEmpty()) {
                    synchronized (rooms) {
                        rooms.remove(roomNumber);
                    }
                    System.out.printf("방 번호 [%d]가 삭제되었습니다.\n", roomNumber);
                } else {
                    roomBroadcast(roomClients, nickname + " 님이 방을 나갔습니다.");
                }
            }
        } finally {
            synchronized (clients) {
                clients.remove(nickname);
            }
        }
    }
}
