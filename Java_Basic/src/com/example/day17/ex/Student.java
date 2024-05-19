package com.example.day17.ex;

import java.util.Comparator;
import java.util.Objects;

public class Student implements Comparable<Student> {
    private String name;
    private int age;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public Student(String name, int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public int getAge() {
        return age;
    }

    public int getScore() {
        return score;
    }

    public boolean overScore(int i) {
        return score >= i;
    }

    public void printName() {
        System.out.println(name);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        return this.name.compareTo(o.name);
    }
}
