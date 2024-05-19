package com.example.day10.collection;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Integer> scores = new ArrayList<>();

        // 점수 입력 받기
        readScores(input, scores);

        // 0점 제거
        removeZero(scores);

        // 결과 출력
        printScores(scores);

        // 리소스 정리
        input.close();
    }

    private static void readScores(Scanner input, List<Integer> scores) {
        while (true) {
            System.out.print("점수 입력 : ");
            try {
                int num = input.nextInt();

                if (num < 0 || num > 100) {
                    throw new InputMismatchException();
                }

                scores.add(num);

                if (num == 0) {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println(e.toString());
                System.out.println("0-100사이의 숫자만 입력이 가능합니다.");
                input.nextLine();
            }
        }
    }

    private static void removeZero(List<Integer> scores) {
        scores.remove(Integer.valueOf(0));
    }

    private static void printScores(List<Integer> scores) {
        int sum = 0;

        for (int i = 0; i < scores.size(); i++) {
            System.out.println((i + 1) + "번째 학생 점수 : " + scores.get(i));
            sum += scores.get(i);
        }

        System.out.println("=============");
        System.out.println("총점 : " + sum);
        System.out.println("평군 : " + sum / scores.size());
    }
}
