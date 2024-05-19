package com.example.day10.generic.inheritance;

public class SpecialBox<T> extends Box<T>{
    public SpecialBox(T content){
        super(content);
    }

    @Override
    public void printContent(){
        System.out.println("special box contains: " + getContent());
    }
}
