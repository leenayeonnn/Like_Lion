package org.example.restexam.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.restexam.domain.Todo;
import org.example.restexam.service.TodoService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// url -- 자원 => 복수 표현

// http://localhost:8080/api/todos      -- Get (R) : list 리턴
// http://localhost:8080/api/todos/{id} -- Get (R) : 특정 id의 todo 리턴
// http://localhost:8080/api/todos      -- Post (C) : todo 하나 저장
// http://localhost:8080/api/todos      -- Put/Patch (U) : todo 수정
// http://localhost:8080/api/todos      -- Delete (D) : todo 삭제

@RestController
@RequestMapping("/api/todos")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService service;

    @GetMapping
    public List<Todo> getTodos() {
        return service.getTodos();
    }

    @GetMapping("/{id}")
    public Todo getTodo(@PathVariable("id") Long id) {
        return service.getTodo(id);
    }

    @PostMapping
    public Todo addTodo(@RequestBody Todo todo) {
        return service.addTodo(todo.getTodo());
    }

    // Put : 값 자체가 바뀔때
    // Path : 부분 수정

    @PatchMapping("/{id}")
    public Todo updateById(@PathVariable("id") Long id) {
        return service.updateTodo(id);
    }

    @PatchMapping
    public Todo updateTodo(@RequestBody Todo todo) {
        return service.updateeTodo(todo);
    }

    @DeleteMapping
    public String deleteTodo(@RequestBody Todo todo) {
        service.deleteTodo(todo.getId());
        return "OK";
    }
}
