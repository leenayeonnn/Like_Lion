package com.example.day10.collection.Ex;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordCollectionExam {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> words = new ArrayList<>();
        inputWords(sc, words);
        removeQuit(words);
        printResult(words);
        sc.close();
    }

    private static void inputWords(Scanner sc, List<String> words) {
        while (true) {
            System.out.print("단어 입력 : ");

            String input = sc.nextLine();

            words.add(input);
            if (input.equals("quit")) {
                break;
            }
        }
    }

    private static void removeQuit(List<String> words) {
        words.remove("quit");
    }

    private static void printResult(List<String> words) {
        int sum = 0;
        String longest = "";

        for (int i = 0; i < words.size(); i++) {
            System.out.println((i + 1) + "번째 단어 : " + words.get(i));
            sum += words.get(i).length();

            if (words.get(i).length() > longest.length()) {
                longest = words.get(i);
            }
        }

        System.out.println("========");
        System.out.println("단어 개수 : " + words.size());
        System.out.println("모든 글자수 : " + sum);
        System.out.println("가장 긴 단어 : " + longest);
    }
}
