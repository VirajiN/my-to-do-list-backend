package com.example.demo.dto;

import lombok.Data;

@Data
public class TaskDto {

    private long id;
    private String name;
    private int isInProgress;
    private int isCompleted;
    private String code;
}
