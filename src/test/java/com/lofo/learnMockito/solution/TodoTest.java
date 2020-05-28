package com.lofo.learnMockito.solution;

import com.lofo.learnMockito.todo.Todo;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static java.time.LocalDate.now;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * In this method we will test our object and more particularly its constructor.
 * There is little chance that these tests will be really useful for you in a professional context.
 * They are here more to explain to you the principle of certain basic principles.
 */
public class TodoTest {

    /**
     * The annotation @Test allows to declare the method as a test method and to launch it.
     * A test method should always be written like this:
     * should_ [result we are supposed to get] _with_ [data sent to him]
     * In the following methods, we verify the behavior of our constructor by sending other data.
     * Here with an empty constructor.
     **/
    @Test
    public void should_create_a_todo() {
        /**
         The assertThat method allows you to verify that a variable has certain characteristics.
         Here we just check that it is not zero.
         **/
        Todo newTodo = new Todo();
        assertThat(newTodo).isNotNull();
    }

    /**
     * Here with just a string to name the task
     */
    @Test
    public void should_create_a_todo_with_name() {
        Todo newTodo = new Todo("Todo");
        assertThat(newTodo).isNotNull();
        assertThat(newTodo.getDate()).isEqualTo(now());
        assertThat(newTodo.getTask()).isEqualTo("Todo");
    }

    /**
     * Here with a string to name the task and a date.
     */
    @Test
    public void should_create_a_todo_with_name_and_date() {
        Todo newTodo = new Todo("Todo", "2020-10-10");
        assertThat(newTodo).isNotNull();
        assertThat(newTodo.getDate()).isEqualTo(LocalDate.of(2020, 10, 10));
        assertThat(newTodo.getTask()).isEqualTo("Todo");
    }
}

