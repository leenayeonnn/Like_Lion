package com.example.day15.UDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {
    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket();
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ) {
            InetAddress inetAddress = InetAddress.getByName("localhost");

            byte[] sendData;
            byte[] receiveData = new byte[1024];

            System.out.print("input send msg : ");
            String msg = br.readLine();

            DatagramPacket sendPacket = new DatagramPacket(msg.getBytes(), msg.getBytes().length, inetAddress, 8888);
            socket.send(sendPacket);

            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            socket.receive(receivePacket);
            String receiveMsg = new String(receivePacket.getData()).trim();

            System.out.println(receiveMsg);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
