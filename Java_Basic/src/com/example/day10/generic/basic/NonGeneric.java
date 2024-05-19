package com.example.day10.generic.basic;

public class NonGeneric {
    private Object first; // first는 Object타입이다.
    private Object second; // second는 Object타입이다.

    public NonGeneric(Object first, Object second) {
        this.first = first;
        this.second = second;
    }

    public Object getFirst() {
        return first;
    }

    public Object getSecond() {
        return second;
    }

    public void setFirst(Object first) {
        this.first = first;
    }

    public void setSecond(Object second) {
        this.second = second;
    }

}