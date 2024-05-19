package com.example.day14.multithread;

import java.io.*;
import java.net.ServerSocket;

public class Test1Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(9999);) {

            while (true) {
                new Test1Thread(serverSocket.accept()).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
