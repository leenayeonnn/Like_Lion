package com.example.day11.ex.employee;

import java.util.HashSet;
import java.util.Set;

public class EmployeeManager {
    private Set<Employee> employees = new HashSet<>();

    public void addEmployee(Employee employee) {
        if (employees.add(employee)) {
            System.out.println("추가 완료");
        } else {
            System.out.println("이미 존재하는 사원입니다.");
        }
    }

    public void removeEmployee(Employee employee) {
        if (employees.remove(employee)) {
            System.out.println("삭제 완료");
        } else {
            System.out.println("존재하지 않는 사원 삭제 불가");
        }
    }

    public void findEmployee(String id) {
        for (Employee employee : employees) {
            if (employee.getId().equals(id)) {
                System.out.println(employee);
                return;
            }
        }
        System.out.println("해당 정보를 찾을 수 없습니다.");
    }
}
