package org.example.restexam.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;
import org.example.restexam.Repository.TodoRepository;
import org.example.restexam.domain.Todo;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TodoServiceTest {
    @Autowired
    private TodoService service;
    private static final Logger log = LoggerFactory.getLogger(TodoServiceTest.class);
    @Autowired
    private TodoRepository todoRepository;
    @Autowired
    private TodoService todoService;

    @Test
    void getTodos() {
        List<Todo> todos = service.getTodos();

        todos.forEach(todo -> log.info("Todo :: " + todo));
    }

    @Test
    void getTodo() {
        Todo todo = service.getTodo(1L);
        log.info("Todo :: " + todo);
    }

    @Test
    void addTodo() {
        Todo todo = service.addTodo("todo4");
        log.info("added todo :: " + todo);
    }

    @Test
    void updateTodoState() {
        log.info("Before ::: " + service.getTodo(1L));
        Todo todo = service.updateTodo(1L);
        log.info("After ::: " + service.getTodo(1L));
    }

    @Test
    void updateTodoContent() {
        log.info("Before ::: " + service.getTodo(1L));
        Todo todo = new Todo("update todo1");
        todo.setId(1L);
        service.updateeTodo(todo);
        log.info("After ::: " + service.getTodo(1L));
    }

    @Test
    void deleteTodo() {
        todoService.deleteTodo(1L);
        log.info("todo ::: " + service.getTodo(1L));
    }
}