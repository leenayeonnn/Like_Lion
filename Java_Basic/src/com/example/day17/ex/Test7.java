//package com.example.day17.ex;
//
//import java.util.Arrays;
//import java.util.Comparator;
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//
//public class Test7 {
//    public static void main(String[] args) {
//        List<Temperature> temperatures = Arrays.asList(
//                new Temperature("Seoul", 33),
//                new Temperature("New York", 30),
//                new Temperature("Seoul", 34),
//                new Temperature("New York", 28)
//        );
//
//        Map<String, List<Temperature>> maxByCity = temperatures.stream()
//                        .collect(Collectors.groupingBy(Temperature::getCity));
//
//        maxByCity.forEach(());
//    }
//}
