package com.example.day14.single;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Test2Server {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        BufferedReader br = null;
        PrintWriter pw = null;
        try {
            // 1. ServerSocket Generate
            serverSocket = new ServerSocket(9999);
            System.out.println("서버 준비 완료");

            // 2. Client Connect Accept
            socket = serverSocket.accept();
            System.out.println("클라이언트 요청 허락 - Connect!!");
            System.out.println("client address ; " + socket.getInetAddress().getHostAddress());

            // 3. Data Read/Write
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println("클라이어트에서 받은 메시지 : " + line);

                // 그대로 다시 클라이언트에게 보냄
                pw.println(line);
                pw.flush();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            // 4. exit connect
            try {
                if (pw != null) {
                    pw.close();
                }
                if (br != null) {
                    br.close();
                }
                if (socket != null) {
                    socket.close();
                }
                if (serverSocket != null) {
                    serverSocket.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
