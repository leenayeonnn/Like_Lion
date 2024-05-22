package org.example.springmvc.controller;

import jakarta.validation.Valid;
import org.example.springmvc.domain.UserForm;
import org.example.springmvc.domain.UserForm2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FormController {
    @GetMapping("/form")
    public String form() {
        return "form";
    }

    @GetMapping("/form2")
    public String form2(Model model) {
        model.addAttribute("userForm", new UserForm2());
        return "form2";
    }

//    @PostMapping("/submitForm")
//    public String submitForm(@RequestParam String username, @RequestParam String password) {
//        System.out.println(username + " " + password);
//        return "result";
//    }

    @PostMapping("/submitForm")
    public String submitForm(@ModelAttribute UserForm userForm) {
        System.out.println(userForm.getUsername() + " " + userForm.getPassword());
        return "result";
    }

    // BindingResult : valid 검사의 결과를 가짐
    @PostMapping("/submitForm2")
    public String submitForm2(@Valid @ModelAttribute("userForm") UserForm2 userForm, BindingResult bindingResultl) {
        if(bindingResultl.hasErrors()){
            System.out.println("hi");
            return "form2";
        }

        return "result";
    }
}
