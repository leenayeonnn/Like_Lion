package com.example.day17.ex;

import java.util.Arrays;
import java.util.List;

public class Test3 {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Alice", 82),
                new Student("Bob", 90),
                new Student("Charlie", 72),
                new Student("David", 76)
        );

        students.stream()
                .filter(student -> student.overScore(80))
                .sorted()
                .forEach(Student::printName);
    }
}
