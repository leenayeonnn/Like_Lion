package com.example.day14.multiChat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Test1Client {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try (
                BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in))
        ) {
            String name = inputName(keyboard);
            try (
                    Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true)
            ) {
                enterChat(out, name);
                readChat(in);
                writeChat(keyboard, out);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String inputName(BufferedReader keyboard) throws IOException {
        System.out.println("input name (if duplicate, auto serialize): ");
        return keyboard.readLine();
    }

    private static void enterChat(PrintWriter out, String name) {
        out.println(name);
    }

    private static void readChat(BufferedReader in) {
        new Test1ListenerThread(in).start();
    }

    private static void writeChat(BufferedReader keyboard, PrintWriter out) throws IOException {
        while (true) {
            String msg;
            if ("exit".equalsIgnoreCase((msg = keyboard.readLine()))) {
                break;
            }
            out.println(msg);
        }
        out.println("exit");
    }
}