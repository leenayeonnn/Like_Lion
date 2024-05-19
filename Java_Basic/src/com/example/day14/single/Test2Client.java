package com.example.day14.single;

import java.io.*;
import java.net.Socket;

public class Test2Client {
    public static void main(String[] args) {
        Socket socket = null;
        PrintWriter pw = null;
        BufferedReader br = null;
        BufferedReader input = null;

        try {
            // 1. Socket Generate
            socket = new Socket("127.0.0.1", 9999);
            System.out.println("9999 포트와 연결");

            // 2. Date Read/Write
            pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // client input
            input = new BufferedReader(new InputStreamReader(System.in));

            String line = null;
            while ((line = input.readLine()) != null) {
                if (line.equalsIgnoreCase("quit")) {
                    break;
                }

                pw.println(line);
                pw.flush();

                String echo = br.readLine();
                System.out.println("msg from server : " + echo);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            // 3. exit connect
            try {
                if (input != null) {
                    input.close();
                }
                if (br != null) {
                    br.close();
                }
                if (pw != null) {
                    pw.close();
                }
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
