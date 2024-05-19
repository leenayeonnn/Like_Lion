package com.example.day15.multiChat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClient {
    public static void main(String[] args) {
        // first input = id
        if (args.length != 1) {
            System.out.println("사용법 : java ChatClient id");
            System.exit(1);
        }

        try (
                Socket socket = new Socket("localhost", 9999);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in))
        ) {
            // send id to server
            out.println(args[0]);

            // read (receive from server) - thread
            new InputThread(socket, in).start();

            // write (send to server)
            String msg = null;
            while ((msg = keyboard.readLine()) != null) {
                out.println(msg);
                if ("/quit".equalsIgnoreCase(msg)) {
                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class InputThread extends Thread {
    private Socket socket;
    private BufferedReader in;

    public InputThread(Socket socket, BufferedReader in) {
        this.socket = socket;
        this.in = in;
    }

    @Override
    public void run() {
        try {
            String msg = null;
            while ((msg = in.readLine()) != null) {
                System.out.println(msg);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
