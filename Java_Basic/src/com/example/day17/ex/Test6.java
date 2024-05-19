package com.example.day17.ex;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test6 {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Alice", 14, 88),
                new Student("Bob", 23, 82),
                new Student("Charlie", 17, 95),
                new Student("David", 21, 73)
        );

        Map<Integer, Double> avgByAgeRange = students.stream()
                .collect(Collectors.groupingBy(student -> (student.getAge() / 10) * 10,
                        Collectors.averagingDouble(Student::getScore)));

        avgByAgeRange.forEach((ageRange, avg) -> System.out.println(ageRange + "s : " + avg));
    }
}
