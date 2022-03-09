package com.example.demo.Response;

import com.example.demo.Status;
import lombok.Data;

@Data
public class TaskResponse {

    private String code;
    private String name;
    private Status status;
}
