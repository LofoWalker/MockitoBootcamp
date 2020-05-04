package com.lofo.learnMockito.todo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Todo {

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String task;

    @Column
    private LocalDate date;

    public Todo() {}

    public Todo(String task, LocalDate date) {
        this.task = task;
        this.date = date;
    }
}
