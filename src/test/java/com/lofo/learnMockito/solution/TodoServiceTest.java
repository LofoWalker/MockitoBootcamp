package com.lofo.learnMockito.solution;

import com.lofo.learnMockito.todo.Todo;
import com.lofo.learnMockito.todo.TodoRepository;
import com.lofo.learnMockito.todo.TodoService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class TodoServiceTest {

    @Mock
    TodoRepository todoRepository;

    @InjectMocks
    TodoService todoService;

    Todo todo1;
    Todo todo2;
    Todo todo3;
    Todo todo4;

    ArrayList<Todo> listOfTodo;

    @Before
    public void setUp() {
        listOfTodo = new ArrayList<>();

        todo1 = new Todo("Todo1");
        todo2 = new Todo("Todo2");
        todo3 = new Todo("Todo3");
        todo4 = new Todo("Todo4");

        listOfTodo.add(todo1);
        listOfTodo.add(todo2);
        listOfTodo.add(todo3);
        listOfTodo.add(todo4);


        initMocks(this);

        when(todoRepository.save(any())).thenReturn(todo1);
        when(todoRepository.findAll()).thenReturn(listOfTodo);
        when(todoRepository.findByTask(anyString())).thenReturn(todo1);
        when(todoRepository.findById(anyInt())).thenReturn(todo1);
    }

    @Test
    public void should_return_new_todo() {
        Todo getTodo = todoService.addTodo(todo1.getTask());

         assertThat(getTodo.getTask()).isEqualTo(todo1.getTask());
    }

    @Test
    public void should_return_a_list_of_todo() {
        ArrayList<Todo> getTodo = todoService.getAllTodo();

        assertThat(getTodo.size()).isEqualTo(4);
    }

    @Test
    public void should_return_a_todo_by_is_name() {
        Todo getTodo = todoService.getTodoByName("Todo1");

        assertThat(getTodo.getTask()).isEqualTo(todo1.getTask());
    }
}
