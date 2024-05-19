package com.example.day09.innerClass;

public class EventProcessorTest {
    public static void main(String[] args) {
        EventProcessor processor = new EventProcessor();
        processor.processEvent("데이터 업데이트");
        // 출력: 처리 중인 이벤트: 데이터 업데이트
    }
}
