package com.example.day14.multiChat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Map;

public class Test1Handler extends Thread {
    private final Socket socket;
    private final Map<String, PrintWriter> allClients;

    public Test1Handler(Socket socket, Map<String, PrintWriter> allClients) {
        this.socket = socket;
        this.allClients = allClients;
    }

    public void run() {
        String name = null;
        try (
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true)
        ) {
            name = getClientName(in);
            enterChat(name, out);
            sendMessage(name, in);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            exitChat(name);
        }
    }

    private String getClientName(BufferedReader in) throws IOException {
        String name = in.readLine();
        if (allClients.containsKey(name)) {
            int i = 2;
            while (allClients.containsKey(name + i)) {
                i++;
            }
            name += i;
        }

        return name;
    }

    private synchronized void enterChat(String name, PrintWriter out) {
        allClients.put(name, out);
        for (String key : allClients.keySet()) {
            allClients.get(key).printf("[%s]님이 입장하셨습니다.\n", name);
        }
    }

    private void sendMessage(String name, BufferedReader in) throws IOException {
        String msg;
        while ((msg = in.readLine()) != null && !("exit".equals(msg))) {
            synchronized (allClients) {
                for (String key : allClients.keySet()) {
                    allClients.get(key).println(name + " : " + msg);
                }
            }
        }
    }

    private synchronized void exitChat(String name) {
        for (String key : allClients.keySet()) {
            allClients.get(key).printf("[%s]님이 퇴장하셨습니다.\n", name);
        }
    }
}