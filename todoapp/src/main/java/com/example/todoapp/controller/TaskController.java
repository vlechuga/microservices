package com.example.todoapp.controller;

import com.example.todoapp.dto.TaskDTO;
import com.example.todoapp.exceptions.NotFoundException;
import com.example.todoapp.persistence.entity.TaskStatus;
import com.example.todoapp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/")
    public @ResponseBody
    ResponseEntity<TaskDTO> createTask(@RequestBody TaskDTO taskDTO) {
        return new ResponseEntity<>(taskService.create(taskDTO), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public @ResponseBody
    ResponseEntity<List<TaskDTO>> getAllTask() {
        return new ResponseEntity<>(taskService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/by-status/{status}")
    public @ResponseBody
    ResponseEntity<List<TaskDTO>> getAllTaskByStatus(@PathVariable("status") TaskStatus taskStatus) {
        return new ResponseEntity<>(taskService.findAllByStatus(taskStatus), HttpStatus.OK);
    }

    @PutMapping("/mark-as-finished/{id}")
    public ResponseEntity<Void> markAsFinished(@PathVariable("id") long id) throws NotFoundException {
        taskService.updateTaskAsFinished(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") long id) throws NotFoundException {
        taskService.deleteBy(id);
        return ResponseEntity.noContent().build();
    }
}
