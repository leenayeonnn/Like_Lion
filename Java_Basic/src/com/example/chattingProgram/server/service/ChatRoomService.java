package com.example.chattingProgram.server.service;

import com.example.chattingProgram.server.domain.Client;
import com.example.chattingProgram.server.domain.Command;
import com.example.chattingProgram.server.domain.Room;

import java.io.IOException;
import java.util.Map;
import java.util.StringTokenizer;

import static java.lang.System.out;

public class ChatRoomService {
    private static int newRoomNumber;

    public static void enterRoom(Client me, Map<String, Client> clients, Map<Integer, Room> rooms, int roomNumber) throws IOException {
        Room room = rooms.get(roomNumber);

        room.add(me);
        chatting(me, clients, room);
        exitRoom(me, room, rooms);
    }

    private static void exitRoom(Client me, Room room, Map<Integer, Room> rooms) {
        room.remove(me);
        if (room.nobody()) {
            rooms.remove(room.getRoomNumber());
        }
    }

    private static void chatting(Client me, Map<String, Client> clients, Room room) throws IOException {
        sendMessage(me, "- 대화방[" + room.getRoomNumber() + "] -");
        broadcast(room, me.getNickname() + " 님이 방에 입장했습니다.");

        while (true) {
            String msg;
            if ((msg = receiveMessage(me)).isBlank()) {
                continue;
            }

            if (!isStartWithCommand(me, msg)) {
                sendMessage(me, msg);
                continue;
            }

            StringTokenizer st = new StringTokenizer(msg);
            String cmd = st.nextToken();

            if (!isCorrectCommand(me, cmd, st)) {
                continue;
            }

            if (!activeByCommand(me, clients, cmd, st, room)) {
                break;
            }
        }
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
        return Command.isRoomCommand(cmd);
    }

    public static boolean isCorrectCommandUse(String cmd, StringTokenizer st) {
        return Command.isCorrectCommandUse(cmd, st);
    }

    private static boolean isStartWithCommand(Client me, String msg) {
        return msg.charAt(0) == '/';
    }

    private static void broadcast(Room room, String msg) {
        room.allClient().forEach(client -> sendMessage(client, msg));
    }

    public static void sendMessage(Client me, String msg) {
        me.outMessage(msg);
    }

    public static String receiveMessage(Client me) throws IOException {
        return me.inMessage();
    }

    public synchronized static int makeNewRoom(Client me, Map<Integer, Room> rooms) {
        if (rooms.isEmpty()) {
            newRoomNumber = 0;
        }
        rooms.put(++newRoomNumber, new Room(newRoomNumber));

        sendMessage(me, "방 번호 [" + newRoomNumber + "] 가 생성되었습니다.\n");
        System.out.println("방 번호 [" + newRoomNumber + "] 가 생성되었습니다.");

        return newRoomNumber;
    }

    public static boolean activeByCommand(Client me, Map<String, Client> clients, String cmd, StringTokenizer st, Room room) {

        if ("/exit".equals(cmd)) {
            return false;
        }

        switch (cmd) {
            case "/users":
                sendMessage(me, "현재 접속 중인 유저 : " + clients.values());
                break;
            case "/roomUsers":
                sendMessage(me, "현재 방에 있는 유저 : " + room.allClient());
                break;
            case "/whisper":
                whisper(st, me, room);
                break;
            case "/toAll":
                for (Client client : clients.values()) {
                    sendMessage(client, "[전체 메세지] " + client.getNickname() + " : " + st.nextToken());
                }
        }
        return true;
    }

    private static void whisper(StringTokenizer st, Client me, Room room) {
        String whisperNickname = st.nextToken();

        if (me.getNickname().equals(whisperNickname)) {
            out.println("error : 본인에게 귓속말은 불가합니다.");
            return;
        }

        Client whisperClient = findWhisperClient(whisperNickname, room);

        if (whisperClient != null) {
            String msg = st.nextToken();
            sendMessage(whisperClient, "[귓속말] " + me.getNickname() + " : " + msg);
            sendMessage(me, "[귓속말 -> " + whisperNickname + "] " + me.getNickname() + " : " + msg);
        } else {
            sendMessage(me, "error : 존재하지 않는 닉네임 입니다.");
        }
    }

    private static Client findWhisperClient(String whisperNickname, Room room) {
        return room.allClient()
                .stream()
                .filter(client -> client.getNickname().equals(whisperNickname))
                .findFirst()
                .orElse(null);
    }
}