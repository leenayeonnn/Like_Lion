package com.example.day15.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Server {
    public static void main(String[] args) {
        try (
                DatagramSocket socket = new DatagramSocket(8888);
        ) {
            while (true) {
                byte[] receiveData = new byte[1024];
                byte[] sendData;

                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket);

                String msg = new String(receivePacket.getData()).trim();

                InetAddress clientAddress = receivePacket.getAddress();
                int port = receivePacket.getPort();

                DatagramPacket sendPacket = new DatagramPacket(msg.getBytes(), msg.getBytes().length, clientAddress, port);
                socket.send(sendPacket);

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
