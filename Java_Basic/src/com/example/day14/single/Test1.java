package com.example.day14.single;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Test1 {
    public static void main(String[] args) {
        try {
            InetAddress local = InetAddress.getLocalHost();
            System.out.println("local name : " + local.getHostName());
            System.out.println("local address : " + local.getHostAddress());

            System.out.println("======== byte[] 형식의 ip 주소 변환=======");

            byte[] ip = local.getAddress();
            for (int i = 0; i < ip.length; i++) {
                System.out.print(ip[i] & 0xFF);
                if (i != ip.length - 1) {
                    System.out.print(".");
                }
            }
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }

        System.out.println("\n======================");

        try {
            InetAddress address = InetAddress.getByName("www.google.com");
            System.out.println("host name : " + address.getHostName());
            System.out.println("host address : " + address.getHostAddress());
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }
}
