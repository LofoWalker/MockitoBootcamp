package com.lofo.learnMockito.solution;

import com.lofo.learnMockito.todo.Todo;
import com.lofo.learnMockito.todo.TodoService;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static java.time.LocalDate.now;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * We will now test a Service.
 * Until now, the tests allowed more to explore the possibilities of Mockito, here we will focus more
 * on their real interest.
 */
public class TodoServiceTest {

    TodoService todoService = new TodoService();

    /**
     * We will check here that our error handling works correctly
     */
    @Test
    public void should_return_null_when_calling_with_null() {
        assertThat(todoService.changeTodo(null, null, null)).isNull();
    }

    @Test
    public void should_return_null_when_calling_with_null_todo() {
        assertThat(todoService.changeTodo(null, "", now())).isNull();
    }

    @Test
    public void should_return_null_when_calling_with_null_task() {
        assertThat(todoService.changeTodo(new Todo(), null, now())).isNull();
    }

    @Test
    public void should_return_null_when_calling_with_null_date() {
        assertThat(todoService.changeTodo(new Todo(), "", null)).isNull();
    }

    /**
     * Our error cases are therefore all handled. We can move on to the method
     */

    @Test
    public void should_return_new_task() {
        Todo toChange = new Todo("Tache 1", now());
        Todo newTodo = todoService.changeTodo(toChange, "Tache 2", toChange.getDate());

        assertThat(newTodo.getTask()).isEqualTo("Tache 2");
        assertThat(newTodo.getDate()).isEqualTo(toChange.getDate());
    }

    @Test
    public void should_return_new_date() {
        Todo toChange = new Todo("Tache 1", LocalDate.of(2020, 12, 1));
        Todo newTodo = todoService.changeTodo(toChange, toChange.getTask(), LocalDate.of(2020, 12, 31));

        assertThat(newTodo.getTask()).isEqualTo(toChange.getTask());
        assertThat(newTodo.getDate()).isEqualTo(LocalDate.of(2020, 12, 31));
    }

    @Test
    public void should_return_new_date_and_new_task() {
        Todo toChange = new Todo("Tache 1", LocalDate.of(2020, 12, 1));
        Todo newTodo = todoService.changeTodo(toChange, "Tache 2", LocalDate.of(2020, 12, 31));

        assertThat(newTodo.getTask()).isEqualTo("Tache 2");
        assertThat(newTodo.getDate()).isEqualTo(LocalDate.of(2020, 12, 31));
    }
}
