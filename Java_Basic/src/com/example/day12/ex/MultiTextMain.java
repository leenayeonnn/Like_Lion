package com.example.day12.ex;

import java.io.IOException;
import java.util.List;

public class MultiTextMain {
    public static void main(String[] args) {
        String filePath = "src//com//example//day12//ex//txt//multiText.txt";
        TextFileManager fileManager = new TextFileManager(filePath);
        UserInputHandler inputHandler = new UserInputHandler();

        try {
            List<String> userInput = inputHandler.getUserInput();
            fileManager.writeToFile(userInput);

            List<String> fileContent = fileManager.readFromFile();
            System.out.println("Content of the file:");
            fileContent.forEach(System.out::println);
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}
