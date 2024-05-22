package org.example.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

//@RestController
@Controller
public class MyController {
    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String about() {
        return "about";
    }

    @GetMapping("/condition")
    public String condition() {
        return "condition";
    }

    @ResponseBody
    @GetMapping("rest")
    public String rest() {
        return "restbody test!!!";
    }

//    @GetMapping("greeting")
//    public String great(String name, HttpServletRequest request) {
//        // ?변수명=값 을 주소에 추가함
//        // 여러개일 경우 '&' 로 연결
//        System.out.println(name);
//
//        System.out.println("request :: " + request.getParameter("name"));
//
//        return "greeting";
//    }

//    @GetMapping("greeting")
//    public String great(@RequestParam(name = "name", required = false, defaultValue = "lee") String name,
//                        int age, Model model) {
//        System.out.println(name);
//        System.out.println(age);
//
//        // view에 데이터 넘기기
//        model.addAttribute("name", name);
//        model.addAttribute("age", age);
//
//        return "greeting";
//    }

    @GetMapping("greeting")
    public ModelAndView great(@RequestParam(name = "name", required = false, defaultValue = "lee") String name,
                              int age, ModelAndView modelAndView) {

        System.out.println(name);
        System.out.println(age);

        modelAndView.addObject("name", name);
        modelAndView.addObject("age", age);

        modelAndView.setViewName("greeting");

        // 데이터와 view의 이름을 같이 보냄
        return modelAndView;
    }
}
