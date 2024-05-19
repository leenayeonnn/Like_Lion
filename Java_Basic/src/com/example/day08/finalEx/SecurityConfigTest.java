package com.example.day08.finalEx;

public class SecurityConfigTest {
    public static void main(String[] args) {
        String encryptionKey = SecurityConfig.getEncryptionKey();
        System.out.println("암호화 키: " + encryptionKey);
    }
}
