package com.example.day17;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Test2 {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("src/");

        Stream<Path> stream = Files.list(path);
        stream.forEach(p -> System.out.println(p.getFileName()));
        stream.close();

        Stream<String> stream2 = Files.lines(Paths.get("src/com/example/day17/Test1.java"));
        stream2.forEach(System.out::println);
        stream2.close();
    }
}
