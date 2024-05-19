package org.example.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//@RestController
@Controller
public class MyController {
    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/condition")
    public String condition() {
        return "condition";
    }
}
