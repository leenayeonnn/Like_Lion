package org.example.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ParamController {

    // use RequestParam
    @GetMapping("/quest")
    public String quest(@RequestParam(name="name") String name) {
        System.out.println(name);
        return "redirect:/datetime";
    }

    // use PathVariabel
    @GetMapping("/quest/{name}")
    public String quest2(@PathVariable String name) {
        System.out.println(name);
        return "redirect:/datetime";
    }
}
