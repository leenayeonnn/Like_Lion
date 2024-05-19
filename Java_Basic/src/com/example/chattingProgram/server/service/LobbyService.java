package com.example.chattingProgram.server.service;

import com.example.chattingProgram.server.domain.*;

import java.io.IOException;
import java.util.Map;
import java.util.StringTokenizer;

import static java.lang.System.out;

public class LobbyService {
    public static void sendCommand(Client me) {
        sendMessage(me, Command.allExplain());
    }

    public static void sendMessage(Client me, String msg) {
        me.outMessage(msg);
    }

    public static String receiveMessage(Client me) throws IOException {
        return me.inMessage();
    }

    public static boolean isStartWithCommand(Client me, String msg) {
        if (msg.charAt(0) == '/') {
            return true;
        }
        sendMessage(me, "현재 대화방에 들어가 있지 않습니다\n");
        return false;
    }

    public static boolean isCorrectCommand(Client me, String cmd, StringTokenizer st) {
        if (!isUsableCommand(cmd)) {
            sendMessage(me, "error : 사용 불가한 명령입니다.\n");
            return false;
        }

        if (!isCorrectCommandUse(cmd, st)) {
            sendMessage(me, "error : 명령어가 잘못 사용되었습니다.\n");
            return false;
        }

        return true;
    }

    public static boolean isUsableCommand(String cmd) {
        return Command.isLobbyCommand(cmd);
    }

    public static boolean isCorrectCommandUse(String cmd, StringTokenizer st) {
        return Command.isCorrectCommandUse(cmd, st);
    }

    public static boolean activeByCommand(Client me, String cmd, StringTokenizer st, Map<String, Client> clients, Map<Integer, Room> rooms) throws IOException {
        if ("/bye".equals(cmd)) {
            return false;
        }

        int roomNumber;
        switch (cmd) {
            case "/list":
                sendRoomList(me, rooms);
                break;
            case "/create":
                roomNumber = ChatRoomService.makeNewRoom(me, rooms);
                ChatRoomService.enterRoom(me, clients, rooms, roomNumber);
                break;
            case "/join":
                try {
                    roomNumber = Integer.parseInt(st.nextToken());
                    joinRoom(me, clients, rooms, roomNumber);
                } catch (NumberFormatException e) {
                    sendMessage(me, "error : 명령어가 잘못 사용되었습니다.");
                }
                break;
            case "/users":
                sendMessage(me, "현재 접속 중인 유저 : " + clients.values());
                break;
            case "/toAll":
                for (Client client : clients.values()) {
                    sendMessage(client, "[전체 메세지] " + client.getNickname() + " : " + st.nextToken());
                }
        }
        return true;
    }

    private static void joinRoom(Client me, Map<String, Client> clients, Map<Integer, Room> rooms, int roomNumber) throws IOException {
        if (rooms.containsKey(roomNumber)) {
            ChatRoomService.enterRoom(me, clients, rooms, roomNumber);
            return;
        }
        sendMessage(me, "존재하지 않는 방번호 입니다.");
    }

    private static void sendRoomList(Client me, Map<Integer, Room> rooms) {
        if (rooms.isEmpty()) {
            sendMessage(me, "존재하는 방이 없습니다\n");
            return;
        }
        sendMessage(me, "현재 대화방 목록 : " + rooms.keySet());
    }
}