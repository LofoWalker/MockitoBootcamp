package com.lofo.learnMockito.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static java.time.LocalDate.now;

@Controller
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    @PostMapping(path = "/add")
    public @ResponseBody Todo addTodo(@RequestParam String name) {
        Todo todo = new Todo(name, now());
        todoRepository.save(todo);
        return todo;
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Todo> getAllTodo() {
        return todoRepository.findAll();
    }
}
