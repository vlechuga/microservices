package com.example.todoapp.dto;

import com.example.todoapp.persistence.entity.TaskStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TaskDTO {
    private Long id;
    private String title;
    private String description;
    private LocalDateTime eta;
    private TaskStatus taskStatus = TaskStatus.ON_TIME;
    private boolean finished;
}
