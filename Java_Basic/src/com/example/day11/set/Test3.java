package com.example.day11.set;

import java.util.LinkedHashSet;
import java.util.Set;

public class Test3 {
    public static void main(String[] args) {
        String input= "banana";
        Set<Character> chars = new LinkedHashSet<>();

        for(char ch : input.toCharArray()){
            chars.add(ch);
        }

        System.out.print("Unique characters : ");
        for(char ch : chars){
            System.out.print(ch);
        }
    }
}
