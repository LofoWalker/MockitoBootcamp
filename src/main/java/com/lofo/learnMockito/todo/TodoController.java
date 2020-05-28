package com.lofo.learnMockito.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class TodoController {

    @Autowired
    private TodoService todoService;

    @PostMapping(path = "/add")
    public @ResponseBody Todo addTodo(@RequestParam String name) {
        return todoService.addTodo(name);
    }

    @GetMapping(path = "/getAll")
    public @ResponseBody ArrayList<Todo> getAllTodo() {
        return (ArrayList<Todo>) todoService.getAllTodo();
    }

    @GetMapping(path = "/getTodoByName")
    public @ResponseBody Todo getTodoByName(String name) {
        return todoService.getTodoByName(name);
    }

    @GetMapping(path = "/getTodoById")
    public @ResponseBody Todo getTodoById(int id) {
        return todoService.getTodoById(id);
    }

    @PutMapping(path = "/changeTodoTask")
    public @ResponseBody void updateTodoTask(int id, String newTask) {
        todoService.updateTodoTask(id, newTask);
    }
}

