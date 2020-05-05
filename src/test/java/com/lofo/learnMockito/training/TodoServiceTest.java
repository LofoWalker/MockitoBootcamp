package com.lofo.learnMockito.training;

import com.lofo.learnMockito.todo.TodoService;

/**
 * Nous allons à présent tester un Service.
 * Jusqu'à présent, les tests permettaient plus de parcourir les possibilités de Mockito, ici nous allons plus nous focaliser
 * sur leur interêt réel.
 */
public class TodoServiceTest {

    TodoService todoService = new TodoService();;

    /**
     * On va vérifier ici que notre gestion d'erreur fonctionne correctement
     */
    public void should_return_null_when_calling_with_null_parameters() {
    }

    public void should_return_null_when_calling_with_null_todo() {
    }

    public void should_return_null_when_calling_with_null_task() {
    }

    public void should_return_null_when_calling_with_null_date() {
    }

    /**
     * Nos cas d'erreur sont donc tous géré. On peut passer au fonctionnement de la méthode
     */

    public void should_return_new_task() {
    }

    public void should_return_new_date() {
    }

    public void should_return_new_date_and_new_task() {
    }
}
