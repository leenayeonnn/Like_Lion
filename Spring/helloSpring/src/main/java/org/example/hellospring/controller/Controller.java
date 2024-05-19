package org.example.hellospring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("/")
    public String mainPage() {
        return "nice to meet you!!!";
    }

    @GetMapping("/itsTimeFor")
    public String itsTimeFor() {
        return "it's time for";
    }

    @GetMapping("/lunch")
    public String lunchTime() {
        return "lunch!!!!!!!!!";
    }
}
