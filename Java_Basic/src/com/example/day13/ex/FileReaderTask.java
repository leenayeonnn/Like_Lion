package com.example.day13.ex;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTask implements Runnable {
    @Override
    public void run() {
        try (BufferedReader br = new BufferedReader(new FileReader("src//com//example//day13//ex//txt//input.txt"));) {
            String str;
            while ((str = br.readLine()) != null) {
                System.out.println(str);
                Thread.sleep(1000);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
