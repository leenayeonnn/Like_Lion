package com.example.day14.multithread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Test1Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 9999);
             PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedReader input = new BufferedReader(new InputStreamReader(System.in));) {

            String line = null;
            while ((line = input.readLine()) != null) {
                if ("quit".equalsIgnoreCase(line.trim())) {
                    break;
                }

                pw.println(line);

                String echo = br.readLine();
                System.out.println("msg from server : " + echo);
            }

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

