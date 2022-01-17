package dev.controller;

import dev.entity.Todo;
import dev.service.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("todos")
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public ResponseEntity<List<Todo>> list() {
        return ResponseEntity
                .ok()
                .body(this.todoService.findAllTodos());
    }

    @PostMapping
    public ResponseEntity<Todo> create(@RequestBody Todo todoToCreate) {
        return ResponseEntity
                .ok()
                .body(this.todoService.createTodo(todoToCreate));
    }
}
