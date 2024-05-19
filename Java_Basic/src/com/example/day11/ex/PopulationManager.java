package com.example.day11.ex;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PopulationManager {
    private Map<String, Integer> cities = new HashMap<>();

    private void addOrUpdateCity(String city, int population) {
        cities.put(city, population);
        System.out.println("add " + city);
    }

    private void removeCity(String city) {
        if (cities.remove(city) != null) {
            System.out.println("remove " + city);
        } else {
            System.out.println("해당 도시는 없습니다.");
        }
    }

    private void displayPopulation(String city) {
        if (cities.get(city) != null) {
            System.out.println(city + "'s population : " + cities.get(city));
        } else {
            System.out.println("해당 도시는 없습니다.");
        }
    }

    private void displayAll() {
        if (cities.isEmpty()) {
            System.out.println("도시 정보가 없습니다.");
            return;
        }

        System.out.println("-- all city --");
        for (Map.Entry<String, Integer> entry : cities.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        PopulationManager manager = new PopulationManager();
        Scanner scanner = new Scanner(System.in);

        manager.addOrUpdateCity("서울", 10000000);
        manager.addOrUpdateCity("부산", 3500000);

        while (true) {
            System.out.print("명령을 입력하세요 (추가/수정, 삭제, 조회, 전체 조회, 종료): ");
            String command = scanner.nextLine();
            if (command.equals("종료")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            String city;
            switch (command) {
                case "추가/수정":
                    System.out.print("도시 이름을 입력하세요: ");
                    city = scanner.nextLine();
                    System.out.print("인구를 입력하세요: ");
                    int population = scanner.nextInt();
                    manager.addOrUpdateCity(city, population);
                    scanner.nextLine();
                    break;
                case "삭제":
                    System.out.print("도시 이름을 입력하세요: ");
                    city = scanner.nextLine();
                    manager.removeCity(city);
                    break;
                case "조회":
                    System.out.print("도시 이름을 입력하세요: ");
                    city = scanner.nextLine();
                    manager.displayPopulation(city);
                    break;
                case "전체 조회":
                    manager.displayAll();
                    break;
                default:
                    System.out.println("알 수 없는 명령입니다.");
            }
        }
        scanner.close();
    }
}