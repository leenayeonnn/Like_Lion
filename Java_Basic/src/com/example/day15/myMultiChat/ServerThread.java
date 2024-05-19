package com.example.day15.myMultiChat;

import com.example.day15.myMultiChat.domain.ChatRoom;
import com.example.day15.myMultiChat.domain.Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;
import java.util.Map;

public class ServerThread extends Thread {
    private static final int START_PORT_NUMBER = 1025;

    private Socket socket;
    private List<ChatRoom> chatRooms;
    private Map<Client, PrintWriter> clients;
    private Client me;

    public ServerThread(Socket socket, List<ChatRoom> chatRooms, Map<Client, PrintWriter> clients) {
        this.socket = socket;
        this.chatRooms = chatRooms;
        this.clients = clients;
    }

    @Override
    public void run() {
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter pw = new PrintWriter(socket.getOutputStream());
        ) {
            String name;
            while ((name = br.readLine()) != null) {
                if (!isDuplicateName((name = br.readLine()))) {
                    pw.println("true");
                    break;
                }
                pw.println("false");
            }

            me = new Client(name);
            synchronized (clients) {
                clients.put(me, pw);
            }

            while (true) {
                String msg = br.readLine();
                if (msg.equals("1")) {
                    makeNewChatRoom(br, pw);
                } else if (msg.equals("2")) {
                    existChatRoom(br, pw);
                } else if (msg.equals("3")) {
                    break;
                } else {
                    pw.println("잘못된 입력입니다.");
                }
            }

            pw.println("서버 나감");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            clients.remove(me);
        }
    }

    private boolean isDuplicateName(String name) {
        for (Client client : clients.keySet()) {
            if (client.equals(name))
                return true;
        }
        return false;
    }

    private void makeNewChatRoom(BufferedReader br, PrintWriter pw) throws IOException {
        ChatRoom chatRoom = new ChatRoom(START_PORT_NUMBER + chatRooms.size());

        if ("yes".equals(br.readLine())) {
            chatRoom.changeToPrivate(br.readLine());
        }
        synchronized (chatRooms) {
            chatRooms.add(chatRoom);
        }

        pw.println("채팅방이 생성되었습니다.");
        chatRoom.enter(me);
    }

    private void existChatRoom(BufferedReader br, PrintWriter pw) throws IOException {
        int roomNumber = Integer.parseInt(br.readLine());
        for (ChatRoom chatRoom : chatRooms) {
            if (chatRoom.equals(roomNumber)) {
                pw.println("채팅방을 찾았습니다");
                chatRoom.enter(me);
                return;
            }
        }
        pw.println("해당 채팅방이 없습니다.");
    }
}
