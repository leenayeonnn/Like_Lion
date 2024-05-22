package org.example.springmvc.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.example.springmvc.domain.Item;
import org.example.springmvc.domain.Product;
import org.example.springmvc.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExamController {

    @GetMapping("/welcome")
    public String welcome(Model model) {
        model.addAttribute("welcomeMsg", "Welcome to Spring MVC!");

        List<Item> items = Arrays.asList(
                new Item("pen", 3000),
                new Item("note", 5000),
                new Item("cup", 15000),
                new Item("keyboard", 300000)
        );

        model.addAttribute("items", items);

        return "welcome";
    }

    private List<Product> products = new ArrayList<>(Arrays.asList(
            new Product(1, "Apple", 1.20),
            new Product(2, "Banana", 0.75),
            new Product(3, "Cherry", 2.05)
    ));

    @GetMapping("/product")
    public String product(Model model) {
        model.addAttribute("title", "product list");
        model.addAttribute("products", products);
        return "product";
    }

    @GetMapping("/example")
    public String example(Model model) {
        model.addAttribute("userName", "lee");
        model.addAttribute("isAdmin", true);
        model.addAttribute("languages", new String[]{"eng","ko","jp"});

        return "exam";
    }

    @GetMapping("/users")
    public String users(Model model) {
        List<User> users = new ArrayList<>(Arrays.asList(
                new User("kim", false),
                new User("lee", true),
                new User("park", false),
                new User("song", false)
        ));

        model.addAttribute("users", users);
        return "users";
    }
}
