package com.example.day17.ex;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test4 {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "HR", 3000),
                new Employee("Bob", "HR", 2000),
                new Employee("Charlie", "Engineering", 5000),
                new Employee("David", "Engineering", 4000)
        );

        Map<String, Double> salaryByGroup = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)));

        salaryByGroup.forEach((department, avgSalary) -> {
            System.out.println(department + " : " + avgSalary);
        });
    }
}
