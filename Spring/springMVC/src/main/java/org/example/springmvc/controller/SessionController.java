package org.example.springmvc.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("visitCount2") // visitCount2 가 나오면 session에 저장해줌
public class SessionController {
//    //no annotation @SessionAttributes("visitCount2")
//    @GetMapping("/visit2")
//    public String trackVisit(HttpSession session) {
//        Integer visitCount = (Integer) session.getAttribute("visitCount");
//        if (visitCount == null) {
//            visitCount = 0;
//        }
//        visitCount++;
//
//        session.setAttribute("visitCount", visitCount);
//
//        return "visit2";
//    }

    // 초기값 설정
    @ModelAttribute("visitCount2")
    public int initCount2() {
        return 0;
    }

    // use annotation @SessionAttributes("visitCount2")
    @GetMapping("/visit2")
    public String trackVisit(@ModelAttribute("visitCount2") Integer visitCount2, Model model) {
        visitCount2++;
        model.addAttribute("visitCount2", visitCount2);
        return "visit2";
    }

    // 더 권장하는 방법
    @GetMapping("/resetVisit")
    public String resetVisit(SessionStatus sessionStatus) {
        sessionStatus.setComplete(); // 세션의 모든 정보를 삭제함
        return "redirect:/visit2";
    }

    // url이 동일해도 Mapping 방식을 다르게 하면 가능함
    // 즉, 여러 방식으로 처리하게 구현이 가능함
    @PostMapping("/resetVisit")
    public String resetVisitPost(SessionStatus sessionStatus) {
        sessionStatus.setComplete(); // 세션의 모든 정보를 삭제함
        return "redirect:/visit2";
    }

//    @GetMapping("/resetVisit")
//    public String resetVisit(HttpSession session) { // 어노테이션의 세션이랑 해당 세션이 다르기 때문에 초기화 안됨
//        session.removeAttribute("visitCount2"); // 세션의 특정 부분만 삭제함
//        return "redirect:/visit2";
//    }
}
