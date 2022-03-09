package com.example.demo.service;

import com.example.demo.dto.TaskDto;
import com.example.demo.entity.Task;
import com.example.demo.exception.RecordNotFoundException;
import com.example.demo.exception.ResourceAlreadyExistsException;
import com.example.demo.repository.TaskRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

@Service
public class TasksManagerService {

    private final TaskRepository taskRepository;

    public TasksManagerService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public TaskDto saveTask(TaskDto task)  {

            Random rd = new Random();
            Task taskEntity = new Task();
            task.setId(rd.nextLong());
            BeanUtils.copyProperties(task, taskEntity);
            TaskDto taskDto = new TaskDto();
            BeanUtils.copyProperties(taskRepository.save(taskEntity), taskDto);
            return taskDto;

    }

    public TaskDto updatetask(TaskDto task){
        Optional<Task> resProduct = taskRepository.findById(task.getId);
        if(resProduct.isPresent()) {
            Task taskEntity = new Task();
            BeanUtils.copyProperties(task, taskEntity);
            TaskDto taskDto = new TaskDto();
            BeanUtils.copyProperties(taskRepository.save(taskEntity), taskDto);
            return taskDto;
        }else {
            throw new RecordNotFoundException("Task does not exist");
        }
    }

    public List<Task> getTaskDetails() {
        List<Task> productDetails = taskRepository.findAll();
        return productDetails;
    }
}
