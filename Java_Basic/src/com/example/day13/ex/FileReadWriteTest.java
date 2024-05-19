package com.example.day13.ex;

public class FileReadWriteTest {
    public static void main(String[] args) {
        Thread readThread = new Thread(new FileReaderTask());
        Thread writeThread = new Thread(new FileWriterTask());

        readThread.start();
        writeThread.start();
    }
}
