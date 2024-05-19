package com.example.day14.single;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Test3Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(9999);
             Socket socket = serverSocket.accept();
             BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);) {

            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println("msg from client : " + line);

                // 그대로 다시 클라이언트에게 보냄
                pw.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
