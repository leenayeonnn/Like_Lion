package com.example.day14.multithread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Test1Thread extends Thread {
    private Socket socket;

    public Test1Thread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        System.out.println("connect : " + socket.getInetAddress().getHostAddress());

        try (BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);) {

            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println("msg from client : " + line);
                pw.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}