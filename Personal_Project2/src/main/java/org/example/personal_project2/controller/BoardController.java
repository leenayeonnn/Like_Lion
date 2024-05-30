package org.example.personal_project2.controller;

import lombok.RequiredArgsConstructor;
import org.example.personal_project2.domain.Board;
import org.example.personal_project2.service.BoardService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class BoardController {
    private final BoardService service;

    // 게시판 리스트
    // 5개씩 출력
    @GetMapping("/list")
    public String boards(Model model,
                         @RequestParam(defaultValue = "1") int page,
                         @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page - 1, size);

        Page<Board> boards = service.findAllBoard(pageable);

        model.addAttribute("boards", boards);
        model.addAttribute("currentPage", page);
        return "board/list";
    }

    // 상세 보기
    @GetMapping("/view")
    public String readDetail(@RequestParam Long id, Model model) {
        model.addAttribute("board", service.findById(id));
        return "board/detail";
    }

    // 등록 폼
    @GetMapping("/writeform")
    public String writeForm(Model model) {
        model.addAttribute("board", new Board());
        return "board/writeform";
    }

    // 등록하기
    @PostMapping("/write")
    public String writeBoard(@ModelAttribute("board") Board board) {
        service.saveBoard(board);
        return "redirect:/list";
    }

    // 삭제 폼
    @GetMapping("/deleteform")
    public String deleteForm(@RequestParam Long id, Model model) {
        model.addAttribute("id", id);
        return "board/deleteform";
    }

    // 삭제하기
    @PostMapping("/deleteform")
    public String deleteBoard(@RequestParam Long id,
                              @RequestParam String password,
                              Model model,
                              RedirectAttributes redirectAttributes) {

        if (service.deleteBoard(id, password)) {
            redirectAttributes.addFlashAttribute("message", "success delete board");
            return "redirect:/list";
        }

        model.addAttribute("id", id);
        model.addAttribute("error", "is not correct");

        return "board/deleteform";
    }

    // 수정 폼
    @GetMapping("/updateform")
    public String updateForm(@RequestParam Long id, Model model) {
        model.addAttribute("id", id);
        model.addAttribute("board", service.findById(id));
        return "board/updateform";
    }

    // 수정하기
    @PostMapping("/updateform")
    public String updateBoard(@ModelAttribute("board") Board board,
                              Model model,
                              RedirectAttributes redirectAttributes) {

        if (service.updateBoard(board)) {
            redirectAttributes.addFlashAttribute("message", "success edit board");
            return "redirect:/list";
        }

        model.addAttribute("id", board.getId());
        model.addAttribute("error", "is not correct");

        return "board/updateform";

    }
}