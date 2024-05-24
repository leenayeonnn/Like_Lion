package org.example.personal_project2.controller;

import lombok.RequiredArgsConstructor;
import org.example.personal_project2.domain.Board;
import org.example.personal_project2.service.BoardService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService service;

    @GetMapping
    public String boards(Model model,
                         @RequestParam(defaultValue = "1") int page,
                         @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page - 1, size);

        Page<Board> boards = service.findAllBoard(pageable);

        model.addAttribute("boards", boards);
        model.addAttribute("currentPage", page);
        return "board/list";
    }

    @GetMapping("/view")
    public String readDetail(@RequestParam Long id, Model model) {
        model.addAttribute("board", service.findById(id));
        return "board/detail";
    }

    @GetMapping("/writeform")
    public String writeForm(Model model) {
        model.addAttribute("board", new Board());
        return "board/writeform";
    }

    @PostMapping("/writeform")
    public String writeBoard(@ModelAttribute("board") Board board) {
        service.saveBoard(board);
        return "redirect:/board";
    }

    @GetMapping("/deleteform")
    public String deleteForm(@RequestParam Long id, Model model) {
        model.addAttribute("id", id);
        return "board/deleteform";
    }

    @PostMapping("/deleteform")
    public String deleteBoard(@RequestParam Long id,
                              @RequestParam String password,
                              Model model) {

        if (service.deleteBoard(id, password)) {
            return "redirect:/board";
        }

        model.addAttribute("id", id);
        model.addAttribute("error", "is not correct");

        return "board/deleteform";
    }

    @GetMapping("/updateform")
    public String updateForm(@RequestParam Long id, Model model) {
        model.addAttribute("id", id);
        model.addAttribute("board", service.findById(id));
        return "board/updateform";
    }

    @PostMapping("/updateform")
    public String updateBoard(@ModelAttribute("board") Board board,
                              Model model) {

        if (service.updateBoard(board)) {
            return "redirect:/board";
        }

        model.addAttribute("id", board.getId());
        model.addAttribute("error", "is not correct");

        return "board/updateform";

    }
}