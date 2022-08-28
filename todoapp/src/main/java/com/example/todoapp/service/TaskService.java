package com.example.todoapp.service;

import com.example.todoapp.dto.TaskDTO;
import com.example.todoapp.exceptions.NotFoundException;
import com.example.todoapp.mapper.TaskMapper;
import com.example.todoapp.persistence.entity.Task;
import com.example.todoapp.persistence.entity.TaskStatus;
import com.example.todoapp.persistence.reporsitory.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public TaskDTO create(TaskDTO taskDTO) {
        final Task task = TaskMapper.toEntity(taskDTO);
        return TaskMapper.toDTO(taskRepository.save(task));
    }

    public List<TaskDTO> findAll() {
        final List<Task> list = taskRepository.findAll();
        return list.stream().map(item -> TaskMapper.toDTO(item)).collect(Collectors.toList());
    }

    public List<TaskDTO> findAllByStatus(TaskStatus taskStatus) {
        final List<Task> list = taskRepository.findAllByTaskStatus(taskStatus);
        return list.stream().map(item -> TaskMapper.toDTO(item)).collect(Collectors.toList());
    }

    @Transactional
    public void updateTaskAsFinished(long id) throws NotFoundException {
        final Optional optionalTask = taskRepository.findById(id);
        if (optionalTask.isEmpty()) {
            throw new NotFoundException("Task not found");
        }
        taskRepository.markTaskAsFinished(id);
    }

    @Transactional
    public void deleteBy(long id) throws NotFoundException {
        final Optional optionalTask = taskRepository.findById(id);
        if (optionalTask.isEmpty()) {
            throw new NotFoundException("Task not found");
        }
        taskRepository.deleteById(id);
    }
}
