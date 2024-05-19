package com.example.day12.IO;

import java.io.File;
import java.util.Arrays;

public class Test11 {
    public static void main(String[] args) {
        File dir = new File(".");
        System.out.println(Arrays.toString(dir.list()));
    }
}
