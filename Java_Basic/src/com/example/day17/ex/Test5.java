package com.example.day17.ex;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test5 {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Laptop", "Electronics", 1200.00),
                new Product("Smartphone", "Electronics", 700.00),
                new Product("Desk", "Furniture", 300.00),
                new Product("Chair", "Furniture", 150.00)
        );

        Map<String, Double> priceByCategory = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory,
                        Collectors.averagingDouble(Product::getPrice)));

        priceByCategory.forEach((category, avg) -> System.out.println(category + " : " + avg));
    }
}
