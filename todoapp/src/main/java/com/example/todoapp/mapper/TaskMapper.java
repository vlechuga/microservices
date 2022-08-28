package com.example.todoapp.mapper;

import com.example.todoapp.dto.TaskDTO;
import com.example.todoapp.persistence.entity.Task;
import com.example.todoapp.persistence.entity.TaskStatus;

import java.time.LocalDateTime;

public class TaskMapper {

    public static Task toEntity(TaskDTO taskDTO) {
        if (taskDTO == null) {
            return null;
        }
        Task task = new Task();
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setEta(taskDTO.getEta());
        task.setCreatedDate(LocalDateTime.now());
        task.setFinished(false);
        task.setTaskStatus(TaskStatus.ON_TIME);
        return task;
    }

    public static TaskDTO toDTO(Task task) {
        if (task == null) {
            return null;
        }
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setId(task.getId());
        taskDTO.setTitle(task.getTitle());
        taskDTO.setDescription(task.getDescription());
        taskDTO.setEta(task.getEta());
        taskDTO.setFinished(task.isFinished());
        taskDTO.setTaskStatus(task.getTaskStatus());
        return taskDTO;
    }
}
