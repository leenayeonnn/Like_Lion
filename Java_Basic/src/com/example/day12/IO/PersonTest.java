package com.example.day12.IO;

import java.io.*;

public class PersonTest {
    // 객체 IO
    public static void main(String[] args) {
        Person person = new Person("kang", 20);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src//com//example//day12//txt//PersonTestOutput.txt"));
             ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src//com//example//day12//txt//PersonTestOutput.txt"))) {

            oos.writeObject(person);

            //////////

            System.out.println(ois.readObject().toString());

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
