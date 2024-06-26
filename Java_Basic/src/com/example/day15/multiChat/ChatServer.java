package com.example.day15.multiChat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

public class ChatServer {
    public static void main(String[] args) {
        //1. 서버소켓을 생성!!
        try (ServerSocket serverSocket = new ServerSocket(9999);) {
            System.out.println("서버가 준비되었습니다.");
            //여러명의 클라이언트의 정보를 기억할 공간
            Map<String, PrintWriter> chatClients = new HashMap<>();
            while (true) {
                //2. accept() 를 통해서 소켓을 얻어옴.   (여러명의 클라이언트와 접속할 수 있도록 구현)
                Socket socket = serverSocket.accept();
                //Thread 이용!!
                //여러명의 클라이언트의 정보를 기억할 공간
                new ChatThread(socket, chatClients).start();

            }
        } catch (Exception e) {
            System.out.println(e);
        }


    }
}

class ChatThread extends Thread {
    //생성자를 통해서 클라이언트 소켓을 얻어옴.
    private Socket socket;
    private String id;
    private final Map<String, PrintWriter> chatClients;

    private BufferedReader in = null;
    private PrintWriter out = null;

    public ChatThread(Socket socket, Map<String, PrintWriter> chatClient) {
        this.socket = socket;
        this.chatClients = chatClient;

        //클라이언트가 생성될 때 클라이언트로 부터 아이디를 얻어오게 하고 싶어요.
        //각각 클라이언트와 통신 할 수 있는 통로얻어옴.
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            // Client가 접속하여 보낸 첫 메시지 = ID
            id = in.readLine();
            //이때..  모든 사용자에게 id님이 입장했다라는 정보를 알려줌.
            broadcast(id + "님이 입장하셨습니다.");
            System.out.println("새로운 사용자의 아이디는 " + id + "입니다.");

            //동시에 일어날 수도..
            synchronized (chatClient) {
                chatClients.put(this.id, out);
            }


        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void run() {
        //run
        //연결된 클라이언트가 메시지를 전송하면, 그 메시지를 받아서 다른 사용자들에게 보내줌..
        String msg = null;
        try {
            while ((msg = in.readLine()) != null) {
                if ("/quit".equalsIgnoreCase(msg))
                    break;
                StringTokenizer st = new StringTokenizer(msg);
                if ("/to".equalsIgnoreCase(st.nextToken())) {
                    whisper(st.nextToken(), msg);
                    continue;
                }
                broadcast(id + " : " + msg);
            }

        } catch (IOException e) {
            System.out.println(e);
        } finally {
            synchronized (chatClients) {
                chatClients.remove(id);
            }
            broadcast(id + "님이 채팅에서 나갔습니다.");

            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            if (out != null) {
                try {
                    out.close();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }

            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    //전체 사용자에게 알려주는 메서드

    public void broadcast(String msg) {
//        for (PrintWriter out : chatClients.values()) {
//            out.println(msg);
//        }

        synchronized (chatClients) {
            Iterator<PrintWriter> it = chatClients.values().iterator();
            while (it.hasNext()) {
                PrintWriter out = it.next();
                try {
                    out.println(msg);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
    }

    private void whisper(String id, String msg) throws IOException {
        if (chatClients.get(id) == null) {
            chatClients.get(this.id).println(id + "가 없습니다.");
            return;
        }

        chatClients.get(this.id).println("[귓속말 to " + id + "] " + msg.substring(5 + id.length()));
        chatClients.get(id).println("[귓속말 from " + this.id + "] " + msg.substring(5 + id.length()));
    }
}