package com.example.demo.Requests;

import com.example.demo.Status;

import javax.validation.constraints.NotEmpty;

public class TaskRequest {


    @NotEmpty
    private String name;
    private Status status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
