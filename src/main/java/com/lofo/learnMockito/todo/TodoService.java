package com.lofo.learnMockito.todo;

import java.time.LocalDate;

public class TodoService {

    public Todo changeTodo(Todo toChange, String newTask, LocalDate newDate) {
        if (toChange == null || newTask == null || newDate == null) {
            return null;
        }
        toChange.setDate(newDate);
        toChange.setTask(newTask);
        return toChange;
    }
}
