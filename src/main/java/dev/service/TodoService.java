package dev.service;

import dev.entity.Todo;
import dev.repository.TodoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TodoService {

    private TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> findAllTodos(){
        return this.todoRepository.findAll();
    }


    @Transactional
    public Todo createTodo(Todo todoToCreate) {
        return this.todoRepository.save(todoToCreate);
    }
}
