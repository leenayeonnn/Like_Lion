package org.example.restexam.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.restexam.Repository.TodoRepository;
import org.example.restexam.domain.Todo;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;

    @Transactional(readOnly = true)
    public List<Todo> getTodos() {
        return todoRepository.findAll(Sort.by("id").descending());
    }

    @Transactional(readOnly = true)
    public Todo getTodo(Long id) {
        return todoRepository.findById(id).orElse(null);
    }

    @Transactional
    public Todo addTodo(String todo) {
        return todoRepository.save(new Todo(todo));
    }

    @Transactional
    public Todo updateTodo(Long id) { // 상태 변경
        Todo todo = getTodo(id);
        if (todo != null) {
            todo.setDone(!todo.isDone());
        }
        return todo;
    }

    @Transactional
    public Todo updateeTodo(Todo todo) {// todo 정보 변경
        return todoRepository.save(todo);
    }

    @Transactional
    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }
}
