package org.example.springmvc.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VisitController {
    @GetMapping("/visit")
    public String visit(
            @CookieValue(name = "lastVisit", defaultValue = "N/A") String lastVisit,
            HttpServletResponse response, HttpServletRequest request, Model model
    ) {

        // 최대 3년 까지 쿠키 저장 가능
        Cookie cookie = new Cookie("lastVisit", "lee");
        cookie.setMaxAge(60 * 60 * 24);
        response.addCookie(cookie);

        model.addAttribute("lastVisit", lastVisit);

        Cookie[] cookies = request.getCookies();
        for(Cookie c : cookies) {
            System.out.println(c.getName() + " ::::::: " + c.getValue());
        }


        return "visit";
    }
}
