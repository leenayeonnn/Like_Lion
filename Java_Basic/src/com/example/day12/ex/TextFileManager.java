package com.example.day12.ex;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TextFileManager {
    private String filePath;

    public TextFileManager(String filePath) {
        this.filePath = filePath;
    }

    public void writeToFile(List<String> userInput) throws IOException {
        PrintWriter pw = new PrintWriter(filePath);
        for (String str : userInput) {
            pw.println(str);
        }
        pw.close();
    }

    public List<String> readFromFile() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        List<String> strList = new ArrayList<>();

        String str;
        while ((str = br.readLine()) != null) {
            strList.add(str);
        }
        br.close();

        return strList;
    }
}
