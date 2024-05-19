package com.example.day17;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Test5 {
    public static void main(String[] args) {
        System.out.println("-- flatMap --");

        List<List<String>> nestedList = Arrays.asList(
                Arrays.asList("Apple", "Banana"),
                Arrays.asList("Cherry", "Date")
        );


        List<String> flatList = nestedList.stream()
                .flatMap(Collection::stream)
                .toList();

        System.out.println(flatList);

        System.out.println("=====================");

        List<String> list = Arrays.asList("1 ,3  ,  4,33,  6  ");
        list.stream()
                .flatMapToInt(
                        data -> {
                            String[] strArr = data.split(",");
                            int[] intArr = new int[strArr.length];
                            for (int i = 0; i < strArr.length; i++) {
                                intArr[i] = Integer.parseInt(strArr[i].trim());
                            }
                            return Arrays.stream(intArr);
                        })
                .forEach(System.out::println);

        System.out.println("=====================");

        List<String> list2 = Arrays.asList("1 ,3  ,  4,33,  6  ", "6,2, 377");
        list2.stream().flatMapToInt(data -> Arrays.stream(data.split(","))
                        .mapToInt(str -> Integer.parseInt(str.trim())))
                .forEach(System.out::println);
    }
}
