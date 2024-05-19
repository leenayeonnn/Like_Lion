package com.example.day15.myMultiChat;

import com.example.day15.myMultiChat.domain.Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

public class ChatRoomThread extends Thread {
    Socket socket;
    private Client me;
    private Map<Client, PrintWriter> clients;

    public ChatRoomThread(Socket socket, Client me, Map<Client, PrintWriter> clients) {
        this.socket = socket;
        this.me = me;
        this.clients = clients;
    }

    @Override
    public void run() {
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter pw = new PrintWriter(socket.getOutputStream());
        ) {
            broadcast(me.toString() + "님이 입장하셨습니다.");
            synchronized (clients) {
                clients.put(me, pw);
            }

            String msg = null;
            while ((msg = br.readLine()) != null) {
                if ("/quit".equalsIgnoreCase(msg))
                    break;
                StringTokenizer st = new StringTokenizer(msg);
                if ("/to".equalsIgnoreCase(st.nextToken())) {
                    whisper(st.nextToken(), msg);
                    continue;
                }
                broadcast(me.toString() + " : " + msg);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void broadcast(String msg) {
        for (PrintWriter pw : clients.values()) {
            pw.println(msg);
        }
    }

    private void whisper(String name, String msg) throws IOException {
        for (Client client : clients.keySet()) {
            if (client.equals(name)) {
                clients.get(me).println("[귓속말 to " + client.toString() + "] " + msg.substring(5 + clients.toString().length()));
                clients.get(client).println("[귓속말 from " + me.toString() + "] " + msg.substring(5 + clients.toString().length()));
            }
        }

    }
}
