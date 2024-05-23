package com.example.springmvcfriendexam.controller;

import com.example.springmvcfriendexam.domain.Friend;
import jakarta.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/friend")
public class FriendController {

    private final static List<Friend> friends = new ArrayList<>(Arrays.asList(
            new Friend(1, "lee", "lee@email.com"),
            new Friend(2, "park", "park@email.com"),
            new Friend(3, "kim", "kim@email.com"),
            new Friend(4, "song", "song@email.com"),
            new Friend(5, "jo", "jo@email.com")
    ));

    @GetMapping
    public String friend() {
        return "friend";
    }

    @GetMapping("/regi")
    public String regi(Model model) {
        model.addAttribute("friend", new Friend());
        return "friend/regi";
    }

    @PostMapping("/regi/submit")
    public String regiSubmit(@Valid @ModelAttribute("friend") Friend friend,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "friend/regi";
        }

        if (friends.stream().anyMatch(f -> f.getEmail().equals(friend.getEmail()))) {
            result.addError(new FieldError("friend", "email", "duplicated email is not enable"));
            return "friend/regi";
        }

        if (friends.isEmpty()) {
            friend.setId(1);
        } else {
            friend.setId(friends.getLast().getId() + 1);
        }
        friends.add(friend);

        return "redirect:/friend";
    }

    @GetMapping("/list")
    public String friendList(Model model) {
        model.addAttribute("friends", friends);
        return "friend/list";
    }
}
