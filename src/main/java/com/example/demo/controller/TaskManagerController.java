package com.example.demo.controller;

import com.example.demo.Requests.TaskRequest;
import com.example.demo.Response.TaskResponse;
import com.example.demo.dto.TaskDto;
import com.example.demo.entity.Task;
import com.example.demo.service.TasksManagerService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.rmi.CORBA.Util;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping("/api/task")
public class TaskManagerController {

    private final TasksManagerService tasksManagerService;

    public TaskManagerController(TasksManagerService tasksManagerService) {
        this.tasksManagerService = tasksManagerService;
    }

    @PostMapping
    public ResponseEntity<TaskResponse> addTask(@RequestBody TaskRequest request) {

        TaskDto taskDto = new TaskDto();
        BeanUtils.copyProperties(request, taskDto);
        TaskResponse returnValue = new TaskResponse();

        BeanUtils.copyProperties(tasksManagerService.saveTask(taskDto), returnValue);
        return new ResponseEntity<>(returnValue, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<TaskResponse> updateTask(@RequestBody TaskRequest request) {
        TaskDto taskDto = new TaskDto();
        BeanUtils.copyProperties(request, taskDto);
        TaskResponse returnValue = new TaskResponse();
        BeanUtils.copyProperties(tasksManagerService.updatetask(taskDto), returnValue);
        return new ResponseEntity<>(returnValue, HttpStatus.CREATED);
    }

    @GetMapping(path = "/get-tasks", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<List<Task>> getTask() {
        List<Task> productDetails = tasksManagerService.getTaskDetails();
        return new ResponseEntity<>(productDetails, HttpStatus.ACCEPTED);
    }



}
