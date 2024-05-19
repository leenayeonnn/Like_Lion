package com.example.day12.IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class Test9 {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://likelion.net/");
        InputStream urlInput = url.openStream();

        // URL 에서 한 줄 씩 입력 받아 출력
        BufferedReader br = new BufferedReader(new InputStreamReader(urlInput));

        String str;
        while((str = br.readLine()) != null){
            System.out.println(str);
        }
    }
}
