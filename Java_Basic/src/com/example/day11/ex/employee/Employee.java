package com.example.day11.ex.employee;

import java.util.Objects;

public class Employee {
    private String name;
    private String id;
    private String department;

    public Employee(String name, String id, String department) {
        this.name = name;
        this.id = id;
        this.department = department;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "직원정보 : " +
                "name = '" + name + '\'' +
                ", id = '" + id + '\'' +
                ", department = '" + department + '\'';
    }
}
