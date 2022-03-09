package com.example.demo.Response;

import lombok.Data;

@Data
public class TaskResponse {

    private String code;
    private String name;
    private int isInProgress;
    private int isCompleted;
}
