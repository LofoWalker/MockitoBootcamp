package com.lofo.learnMockito.solution;

import com.lofo.learnMockito.todo.Todo;
import com.lofo.learnMockito.todo.TodoController;
import com.lofo.learnMockito.todo.TodoRepository;
import com.lofo.learnMockito.todo.TodoService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * We will now test a controller.
 * This kind of test requires more knowledge of the tests and in particular of Mockito.
 * No panic, we will see each element point by point.
 */
public class TodoControllerTest {

    private static final String NEW_TASK = "New task";

    /**
     * If you were attentive when reading the article accompanying this project,
     * no need to go back on this annotation. This is how to use it
     */
    @Mock
    TodoService todoService;

    /**
     * This is not described in the article. Right above, we 'mock' TodoRepository.
     * This variable is present in our controller. Now we need to tell our JVM to use
     * the todoRepository object mocked above to avoid a NullPointerException.
     * The annotation @InjectMocks literally (Injection of mocks) thus makes it possible to create the controller by injecting
     * our mocks.
     */
    @InjectMocks
    TodoController todoController;

    Todo newTodo;

    /**
     * The @Before annotation tells Spring that this method should be executed before all the others.
     * This is where we will initiate our framework, our mocks and our variables in order to limit the size of the test methods.
     */
    @Before
    public void setup() {
        newTodo = new Todo(NEW_TASK);

        /**
         * This method will just initiate your mocks.
         */
        initMocks(this);

        /**
         * The objective of a mock is to simulate the behavior of an object. This is where it happens.
         * This line means:
         * When I call the save method of todoRepository with any object of the desired class, then return the newTodo object
         * when (object.methode(any(Object.class)).thenReturn(something);
         *
         * Now the save method in todoRepository will always return newTodo if called with an xTodo object
         **/
        when(todoService.addTodo(any())).thenReturn(newTodo);

        /**
         * I let you guess the translation of this line there*/
        when(todoService.getAllTodo()).thenReturn(new ArrayList<Todo>());
    }

    @Test
    public void should_add_a_todo_and_return_him() {
        Todo getTodo = todoController.addTodo(NEW_TASK);
        /**
         * This method is the same as in TodoTest.java. Simply here,
         * in addition to checking that the object is not zero, we will check its value!
         */
        assertThat(getTodo.getTask()).isEqualTo(newTodo.getTask());
    }

    @Test
    public void should_get_all_todo_and_return_them() {
        ArrayList<Todo> getTodo = todoController.getAllTodo();
        assertThat(getTodo).isNotNull();
    }


    /**
     * Some useful methods:
     * isNotNull (): Checks that the object is not null
     * isEqualTo (value): Check that the return is equal to the value
     * hasSize (size): Check that the return to a size of size
     * contains (value, index): Checks that the return contains the value value at the index index.
     */
}
