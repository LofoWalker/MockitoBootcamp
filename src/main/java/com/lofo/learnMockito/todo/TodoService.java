package com.lofo.learnMockito.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public Todo addTodo(String name) {
        Todo todo = new Todo(name);
        todoRepository.save(todo);
        return todo;
    }

    public ArrayList<Todo> getAllTodo() {
        return todoRepository.findAll();
    }

    public Todo getTodoByName(String name) {
        return todoRepository.findByTask(name);
    }

    public Todo getTodoById(int id) {
        return todoRepository.findById(id);
    }

    @Transactional
    public void updateTodoTask(int id, String newTask) {
        todoRepository.updateTodoTask(id, newTask);
    }
}
