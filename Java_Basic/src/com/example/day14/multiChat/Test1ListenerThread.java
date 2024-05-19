package com.example.day14.multiChat;

import java.io.BufferedReader;
import java.io.IOException;

public class Test1ListenerThread extends Thread {
    private final BufferedReader in;

    public Test1ListenerThread(BufferedReader in) {
        this.in = in;
    }

    public void run() {
        try {
            String msg;
            while ((msg = in.readLine()) != null) {
                System.out.println(msg);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
