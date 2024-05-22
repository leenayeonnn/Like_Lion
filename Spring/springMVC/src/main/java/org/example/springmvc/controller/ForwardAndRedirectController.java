package org.example.springmvc.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ForwardAndRedirectController {
    @GetMapping("/start")
    public String start(Model model) {
        model.addAttribute("forwardTest", "forwardTest");
        return "forward:/forward";
    }

    // forward에 직접 접근하면 model에 대한 정보가 없기에
    // forwardTest라는 문구가 나오지 않음
    @GetMapping("/forward")
    public String forward(Model model, HttpServletRequest request) {
        // 여기서 model은 새로 만들어진 모델이고
        // request에 모델이 저장되 있음을 알 수 있음
        // => request를 통해 모델을 유지함
        System.out.println(model.getAttribute("forwardTest"));
        System.out.println(request.getAttribute("forwardTest"));
        return "forwardPage";
    }

    /////////////////////////////////

    @GetMapping("/redirect")
    public String redirect(Model model) {
        model.addAttribute("redirectTest", "redirectTest");
        return "redirect:/finalDestination";
    }

    // redirect의 경우 2번의 요청을 처리하기 때문에
    // 이전 요청에 있던 model이 요청과 함께 없어져
    // redirectTest 라는 문구가 나오지 않음
    @GetMapping("/finalDestination")
    public String finalDestination(Model model, HttpServletRequest request) {

        System.out.println(model.getAttribute("forwardTest"));
        System.out.println(request.getAttribute("forwardTest"));

        return "redirectPage";
    }
}
