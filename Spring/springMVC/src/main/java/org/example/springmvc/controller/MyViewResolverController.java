package org.example.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyViewResolverController {
    @GetMapping("/custom")
    public String customView(){
        return "my-prefix-result";
    }
}
