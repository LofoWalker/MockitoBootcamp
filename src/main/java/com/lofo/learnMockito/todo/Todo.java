package com.lofo.learnMockito.todo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static java.time.LocalDate.now;

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

    public Todo(String task) {
        this.task = task;
        this.date = now();
    }

    public Todo(String task, String date) {
        this.task = task;
        this.date = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
}
