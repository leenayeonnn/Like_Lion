package org.example.restexam.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import org.example.restexam.domain.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final Map<Long, Product> products = new HashMap<>();
    private final AtomicLong counter = new AtomicLong();

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        Long id = counter.incrementAndGet();
        product.setId(id);
        products.put(id, product);
        return product;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return products.values().stream().toList();
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable("id") Long id) {
        Product product = products.get(id);
        if (product == null) {
            throw new RuntimeException("not found product :: id = " + id);
        }
        return product;
    }

    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        if (!products.containsKey(id)) {
            throw new RuntimeException("not found product :: id = " + id);
        }
        product.setId(id);
        products.put(id, product);
        return product;
    }

    @DeleteMapping("/{id}")
    public Product deleteProduct(@PathVariable("id") Long id) {
        if (!products.containsKey(id)) {
            throw new RuntimeException("not found product :: id = " + id);
        }

        return products.remove(id);
    }
}
