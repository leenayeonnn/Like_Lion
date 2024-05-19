package com.example.day15.myMultiChat.domain;

import java.io.PrintWriter;
import java.util.Objects;

public class Client {
    private String name;

    public Client(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null | !(o instanceof String)) return false;
        String s = (String) o;
        return s.equals(name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
