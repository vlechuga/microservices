package com.example.todoapp.persistence.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "task")
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    private LocalDateTime createdDate;
    private LocalDateTime eta;
    private boolean finished;
    @Enumerated(EnumType.STRING)
    private TaskStatus taskStatus;

}
