package org.example.friendexam.controller;

import lombok.RequiredArgsConstructor;
import org.example.friendexam.domain.Friend;
import org.example.friendexam.service.FriendService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
@RequestMapping("/friends")
public class FriendController {
    private final FriendService service;

//    @GetMapping // no paging
//    public String friends(Model model) {
//        model.addAttribute("friends", service.findAllFriend());
//        return "friends/list";
//    }

    @GetMapping // yes paging
    public String friends(Model model,
                          @RequestParam(defaultValue = "1") int page,
                          @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page - 1, size);

        Page<Friend> friends = service.findAllFriend(pageable);

        model.addAttribute("friends", friends);
        model.addAttribute("currentPage", page);
        return "friends/list";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("friend", new Friend());
        return "friends/form";
    }

    @PostMapping("/add")
    public String addFriend(@ModelAttribute("friend") Friend friend, RedirectAttributes redirectAttributes) {
        service.saveFirend(friend);
        redirectAttributes.addFlashAttribute("message", "success");
        return "redirect:/friends";
    }

    @GetMapping("/{id}")
    public String detailFriend(@PathVariable Long id, Model model) {
        model.addAttribute("friend", service.findFriendById(id));
        return "friends/detail";
    }

    @GetMapping("/delete/{id}")
    public String deleteFriend(@PathVariable Long id) {
        service.deleteFriend(id);
        return "redirect:/friends";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("friend", service.findFriendById(id));
        return "friends/edit";
    }

    @PostMapping("/edit")
    public String editFriend(@ModelAttribute("friend") Friend friend) {
        service.saveFirend(friend);
        return "redirect:/friends";
    }
}
