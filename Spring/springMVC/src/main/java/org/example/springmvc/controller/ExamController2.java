package org.example.springmvc.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExamController2 {
    @GetMapping("/list")
    public String showList(Model model) {
        List<String> items = Arrays.asList("Item 1", "Item 2", "Item 3", "Item 4", "Item 5",
                "Item 6", "Item 7", "Item 8", "Item 9", "Item 10");
        model.addAttribute("items", items);
        return "list";
    }

    @GetMapping("datetime")
    public String showDateTime(Model model) {
        LocalDate date = LocalDate.now();
        LocalDateTime dateTime = LocalDateTime.now();
        LocalTime time = LocalTime.now();
        ZonedDateTime zonedDateTime= ZonedDateTime.now(ZoneId.of("Asia/Seoul"));

        model.addAttribute("date", date);
        model.addAttribute("dateTime", dateTime);
        model.addAttribute("time", time);
        model.addAttribute("zonedDateTime", zonedDateTime);

        return "datetime";
    }
}
