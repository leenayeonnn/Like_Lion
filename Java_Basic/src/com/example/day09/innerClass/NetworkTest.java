package com.example.day09.innerClass;

public class NetworkTest {
    public static void main(String[] args) {
        Network.Message msg1 = new Network.Message("안녕하세요!");
        Network.Message msg2 = new Network.Message("반갑습니다!");
        msg1.send();
        msg2.send();
        System.out.println("네트워크를 통해 전송된 전체 메시지 수: " + Network.getTotalMessages());
        // 출력 예시:
        // 메시지 전송: 안녕하세요!
        // 전체 메시지 수: 1
        // 메시지 전송: 반갑습니다!
        // 전체 메시지 수: 2
        // 네트워크를 통해 전송된 전체 메시지 수: 2
    }
}
