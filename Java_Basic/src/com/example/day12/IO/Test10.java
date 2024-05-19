package com.example.day12.IO;

import java.io.*;

public class Test10 {
    public static void main(String[] args) {
        // 기본적으로 입출력되는 데이터는 모두 byte / char
        // 원시 데이터 타입으로 파일에 출력 및 읽기

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("src//com//example//day12//txt//Test10Output.txt"));
             DataInputStream dis = new DataInputStream(new FileInputStream("src//com//example//day12//txt//Test10Output.txt"))) {

            dos.writeBoolean(true);
            dos.writeByte(Byte.MAX_VALUE);
            dos.writeChar('a');
            dos.writeDouble(1.1);

            //////////////////////

            System.out.println(dis.readBoolean());
            System.out.println(dis.readByte());
            System.out.println(dis.readChar());
            System.out.println(dis.readDouble());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
