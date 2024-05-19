package org.example.iocexam.iocexam.controller;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.example.iocexam.iocexam.domain.User;
import org.example.iocexam.iocexam.service.UserService;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostConstruct
    public void init() {
        // 빈 생성 직후 호출
        System.out.println("post 실행");
    }

    @PreDestroy
    public void destroy() {
        // 빈 소면 직전 호출
        System.out.println("pre 실행");
    }

    public void joinUser() {
        // 실제 동작 시 사용자로 부터 정보 받아옴
        User user = new User();
        user.setName("lee");
        user.setEmail("lee@gmail.com");
        user.setPassword("lee1234");

        userService.joinUser(user);
    }
}
