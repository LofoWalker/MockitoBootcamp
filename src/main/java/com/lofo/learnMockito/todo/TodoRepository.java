package com.lofo.learnMockito.todo;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Long> {

    Todo findByTask(String name);
    Todo findById(int id);

    ArrayList<Todo> findAll();

    @Modifying
    @Query("update Todo s set s.task=:newTask where s.id=:id")
    void updateTodoTask(int id, String newTask);
}
