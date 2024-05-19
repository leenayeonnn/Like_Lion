package com.example.day12.ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class UserInputHandler {
    private List<String> userInput = new ArrayList<>();

    public UserInputHandler() {
        System.out.println("-- 입력해주세요 --");

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
            String str;
            while ((str = br.readLine()) != null && !str.isEmpty()) {
                userInput.add(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> getUserInput() {
        return userInput;
    }
}
