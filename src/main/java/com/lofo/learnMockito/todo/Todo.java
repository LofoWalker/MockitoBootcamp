package com.lofo.learnMockito.todo;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Table(name = "Todo")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String task;

    @Column
    private LocalDate date;

    public Todo() {}

    public Todo(String task, LocalDate date) {
        this.task = task;
        this.date = date;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
