package com.example.demo.Requests;

import javax.validation.constraints.NotEmpty;

public class TaskRequest {

    @NotEmpty
    private String code;
    @NotEmpty
    private String name;
    private int isInProgress;
    private int isCompleted;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIsInProgress() {
        return isInProgress;
    }

    public void setIsInProgress(int isInProgress) {
        this.isInProgress = isInProgress;
    }

    public int getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(int isCompleted) {
        this.isCompleted = isCompleted;
    }
}
